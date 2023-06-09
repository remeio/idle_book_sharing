package com.xumengqi.reme.as.logic.book.impl;

import com.xumengqi.reme.as.logic.book.ShareRecordLogic;
import com.xumengqi.reme.as.logic.deposit.DepositLogic;
import com.xumengqi.reme.as.mapper.ShareRecordExtMapper;
import com.xumengqi.reme.as.vo.RankVO;
import com.xumengqi.reme.as.vo.ShareRecordVO;
import com.xumengqi.reme.base.BizException;
import com.xumengqi.reme.base.util.AssertUtils;
import com.xumengqi.reme.base.util.UUIDUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import com.xumengqi.reme.common.enums.biz.BookStatusEnum;
import com.xumengqi.reme.common.enums.biz.OperatorTypeEnum;
import com.xumengqi.reme.common.enums.biz.ShareRecordStatusEnum;
import com.xumengqi.reme.dao.entity.*;
import com.xumengqi.reme.dao.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * @author xumengqi
 * @date 2021/3/26 19:52
 */
@Component
public class ShareRecordLogicImpl implements ShareRecordLogic {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private ShareRecordMapper shareRecordMapper;

    @Autowired
    private ShareLogMapper shareLogMapper;

    @Autowired
    private DepositLogic depositLogic;

    @Autowired
    private ShareRecordExtMapper shareRecordExtMapper;

    @Autowired
    private MessageMapper messageMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void borrowBook(Long bookId, Long borrowUserId) {
        // 判断借阅者是否存在
        User user = userMapper.selectByPrimaryKey(borrowUserId);
        AssertUtils.asserter().assertNotNull(user).elseThrow(ErrorCodeEnum.USER_NOT_EXIST);
        // 判断书籍是否存在
        Book book = bookMapper.selectByPrimaryKey(bookId);
        AssertUtils.asserter().assertNotNull(book).elseThrow(ErrorCodeEnum.BOOK_NOT_EXIST);
        // 判断书籍的状态是否为空闲
        AssertUtils.asserter().assertTrue(book.getBookStatus().equals(BookStatusEnum.IDLE.getCode()))
                .elseThrow(ErrorCodeEnum.BOOK_BORROWING);
        // 判断是否自享自借
        AssertUtils.asserter().assertFalse(user.getId().equals(book.getUserId())).elseThrow(ErrorCodeEnum.BOOK_BORROW_AND_SHARE_ON_SAME_TIME);
        // 判断押金是否足够
        boolean isNeedDeposit = book.getBookDeposit() > 0;
        if (isNeedDeposit) {
            AssertUtils.asserter().assertGreaterThanOrEqualZero(user.getCanUseDeposit() - book.getBookDeposit())
                    .elseThrow(ErrorCodeEnum.CAN_USE_DEPOSIT_NOT_ENOUGH);
        }
        // 判断近一周有没有违规记录，如果有则不能借阅书籍
        ShareRecordExample shareRecordExampleError = new ShareRecordExample();
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        now.set(Calendar.DATE, now.get(Calendar.DATE) - 7);
        Date before = now.getTime();
        shareRecordExampleError.createCriteria()
                .andBorrowUserIdEqualTo(user.getId())
                .andRecordStatusIn(new ArrayList<>(Arrays.asList(ShareRecordStatusEnum.OVERDUE_RETURNED.getCode(),
                        ShareRecordStatusEnum.LOST_OR_DAMAGED.getCode(),
                        ShareRecordStatusEnum.SERIOUSLY_OVERDUE.getCode())))
                .andGmtCreateGreaterThan(before);
        AssertUtils.asserter().assertEqualZero(shareRecordMapper.countByExample(shareRecordExampleError))
                .elseThrow(ErrorCodeEnum.SHARE_RECORD_HAS_ERROR);
        // 创建共享记录，初始状态为初始化
        ShareRecord shareRecord = new ShareRecord();
        shareRecord.setOrderNo(UUIDUtils.getOrderNo());
        shareRecord.setBookId(bookId);
        shareRecord.setBorrowUserId(borrowUserId);
        shareRecord.setShareUserId(book.getUserId());
        shareRecord.setRecordStatus(ShareRecordStatusEnum.INITIAL_STATE.getCode());
        shareRecord.setGmtCreate(new Date());
        shareRecordMapper.insertSelective(shareRecord);
        // 修改共享记录状态，并记录共享日志，并更新书籍状态
        updateShareRecordStatusAndRecordShareLogAndUpdateBookStatus(shareRecord.getId(), ShareRecordStatusEnum.ORDER_HAS_BEEN_PLACED, OperatorTypeEnum.BORROWER);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void receiveBook(Long shareRecordId, Long borrowUserId) {
        isBorrowUser(shareRecordId, borrowUserId);
        updateShareRecordStatusAndRecordShareLogAndUpdateBookStatus(shareRecordId, ShareRecordStatusEnum.BORROWING, OperatorTypeEnum.BORROWER);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void returnBook(Long shareRecordId, Long shareUserId) {
        isShareUser(shareRecordId, shareUserId);
        // 判断是否是逾期归还
        ShareRecord shareRecord = shareRecordMapper.selectByPrimaryKey(shareRecordId);
        Book book = bookMapper.selectByPrimaryKey(shareRecord.getBookId());
        // 查询借阅天数
        Integer period = book.getBookMaxPeriod();
        // 查询借阅日期
        ShareLogExample shareLogExample = new ShareLogExample();
        shareLogExample.createCriteria().andShareRecordIdEqualTo(shareRecordId).andShareRecordStatusEqualTo(ShareRecordStatusEnum.BORROWING.getCode());
        ShareLog shareLog = shareLogMapper.selectByExample(shareLogExample).stream().findFirst().orElse(null);
        AssertUtils.asserter().assertNotNull(shareLog).elseThrow(ErrorCodeEnum.SYSTEM_ERROR);
        // 比较
        Date now = new Date();
        boolean isOverdue = now.after(new Date(shareLog.getGmtCreate().getTime() + ((period + 2L) * 24 * 60 * 60 * 1000)));
        updateShareRecordStatusAndRecordShareLogAndUpdateBookStatus(shareRecordId, isOverdue ? ShareRecordStatusEnum.OVERDUE_RETURNED : ShareRecordStatusEnum.RETURNED, OperatorTypeEnum.SHARER);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void cancelBorrowBook(Long shareRecordId, Long userId) {
        ShareRecord shareRecord = shareRecordMapper.selectByPrimaryKey(shareRecordId);
        OperatorTypeEnum operatorTypeEnum = null;
        if (shareRecord.getShareUserId().equals(userId)) {
            operatorTypeEnum = OperatorTypeEnum.SHARER;
        } else if (shareRecord.getBorrowUserId().equals(userId)) {
            operatorTypeEnum = OperatorTypeEnum.BORROWER;
        } else {
            BizException.error(ErrorCodeEnum.SYSTEM_ERROR);
        }
        updateShareRecordStatusAndRecordShareLogAndUpdateBookStatus(shareRecordId, ShareRecordStatusEnum.CANCEL_AFTER_ORDER, operatorTypeEnum);
    }


    @Override
    public void lostHandleBook(Long shareRecordId, Long userId) {
        isExistShareRecord(shareRecordId);
        ShareRecord shareRecord = shareRecordMapper.selectByPrimaryKey(shareRecordId);
        OperatorTypeEnum operatorTypeEnum = null;
        if (shareRecord.getShareUserId().equals(userId)) {
            operatorTypeEnum = OperatorTypeEnum.SHARER;
        } else if (shareRecord.getBorrowUserId().equals(userId)) {
            operatorTypeEnum = OperatorTypeEnum.BORROWER;
        } else {
            BizException.error(ErrorCodeEnum.SYSTEM_ERROR);
        }
        updateShareRecordStatusAndRecordShareLogAndUpdateBookStatus(shareRecordId, ShareRecordStatusEnum.LOST_OR_DAMAGED, operatorTypeEnum);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void seriouslyOverdueHandleBook(Long shareRecordId, Long shareUserId) {
        isShareUser(shareRecordId, shareUserId);
        updateShareRecordStatusAndRecordShareLogAndUpdateBookStatus(shareRecordId, ShareRecordStatusEnum.SERIOUSLY_OVERDUE, OperatorTypeEnum.SHARER);
    }


    @Override
    public void isExistShareRecord(Long shareRecordId) {
        AssertUtils.asserter()
                .assertNotNull(shareRecordMapper.selectByPrimaryKey(shareRecordId))
                .elseThrow(ErrorCodeEnum.SHARE_RECORD_NOT_EXIST);
    }

    @Override
    public void isBorrowUser(Long shareRecordId, Long borrowUserId) {
        isExistShareRecord(shareRecordId);
        ShareRecord shareRecord = shareRecordMapper.selectByPrimaryKey(shareRecordId);
        AssertUtils.asserter()
                .assertTrue(shareRecord.getBorrowUserId().equals(borrowUserId))
                .elseThrow(ErrorCodeEnum.SHARE_RECORD_NOT_MATCH);
    }

    @Override
    public void isShareUser(Long shareRecordId, Long shareUserId) {
        isExistShareRecord(shareRecordId);
        ShareRecord shareRecord = shareRecordMapper.selectByPrimaryKey(shareRecordId);
        AssertUtils.asserter()
                .assertTrue(shareRecord.getShareUserId().equals(shareUserId))
                .elseThrow(ErrorCodeEnum.SHARE_RECORD_NOT_MATCH);
    }

    @Override
    public List<ShareRecordVO> getShareRecordListByBorrowUserId(Long userId) {
        return getShareRecordListByUserId(userId, true);
    }

    @Override
    public List<ShareRecordVO> getShareRecordListByShareUserId(Long userId) {
        return getShareRecordListByUserId(userId, false);
    }

    @Override
    public ShareRecordVO getShareRecord(Long shareRecordId) {
        isExistShareRecord(shareRecordId);
        return shareRecordExtMapper.selectById(shareRecordId);
    }

    @Override
    public List<RankVO> getBorrowRankList(int i) {
        return shareRecordExtMapper.getBorrowRankList(i);
    }

    @Override
    public List<RankVO> getShareRankList(int i) {
        return shareRecordExtMapper.getShareRankList(i);
    }

    @Override
    public void sendMessage(Long userId, Long shareRecordId, String messageContent) {
        isExistShareRecord(shareRecordId);
        ShareRecord shareRecord = shareRecordMapper.selectByPrimaryKey(shareRecordId);
        OperatorTypeEnum operatorTypeEnum = null;
        if (shareRecord.getShareUserId().equals(userId)) {
            operatorTypeEnum = OperatorTypeEnum.SHARER;
        } else if (shareRecord.getBorrowUserId().equals(userId)) {
            operatorTypeEnum = OperatorTypeEnum.BORROWER;
        } else {
            BizException.error(ErrorCodeEnum.SYSTEM_ERROR);
        }
        Message message = new Message();
        message.setOperatorType(operatorTypeEnum.getCode());
        message.setShareRecordId(shareRecordId);
        message.setMessageContent(messageContent);
        message.setGmtCreate(new Date());
        messageMapper.insertSelective(message);
    }

    @Override
    public List<Message> getMessageList(Long userId, Long shareRecordId) {
        isExistShareRecord(shareRecordId);
        ShareRecord shareRecord = shareRecordMapper.selectByPrimaryKey(shareRecordId);
        if (!shareRecord.getShareUserId().equals(userId) && !shareRecord.getBorrowUserId().equals(userId)) {
            BizException.error(ErrorCodeEnum.PERMISSION_DENIED);
        }
        MessageExample messageExample = new MessageExample();
        messageExample.createCriteria().andShareRecordIdEqualTo(shareRecordId);
        messageExample.setOrderByClause("gmt_create asc");
        return messageMapper.selectByExample(messageExample);
    }

    @Override
    public void score(Long shareRecordId, Double score, Long borrowUserId) {
        ShareRecordVO record = getShareRecord(shareRecordId);
        isBorrowUser(shareRecordId, borrowUserId);
        // 共享记录状态为 已归还，逾期归还，且尚未评分 才能评分
        AssertUtils.asserter()
                .assertTrue(ShareRecordStatusEnum.RETURNED.getCode().equals(record.getRecordStatus()) || ShareRecordStatusEnum.OVERDUE_RETURNED.getCode().equals(record.getRecordStatus()))
                .assertTrue(record.getScore().equals(Double.parseDouble("0")))
                .elseThrow(ErrorCodeEnum.CAN_NOT_SCORE);
        ShareRecord shareRecord = new ShareRecord();
        shareRecord.setId(shareRecordId);
        shareRecord.setScore(score);
        shareRecordMapper.updateByPrimaryKeySelective(shareRecord);
    }

    @Override
    public Double getScoreOfBook(Long bookId) {
        Book book = bookMapper.selectByPrimaryKey(bookId);
        AssertUtils.asserter().assertNotNull(book).elseThrow(ErrorCodeEnum.BOOK_NOT_EXIST);
        ShareRecordExample shareRecordExample = new ShareRecordExample();
        shareRecordExample.createCriteria()
                .andBookIdEqualTo(bookId)
                .andScoreGreaterThan(0d);
        List<ShareRecord> shareRecordList = shareRecordMapper.selectByExample(shareRecordExample);
        // 总和
        Double scores = shareRecordList.stream().map(ShareRecord::getScore).reduce((aDouble, aDouble2) -> aDouble + aDouble).orElse(null);
        // 平均值
        double score = (scores == null ? 0d : (scores / shareRecordList.size()));
        // 保留 1 位小数
        return ((double) Math.round(score * 10)) / 10;
    }

    private List<ShareRecordVO> getShareRecordListByUserId(Long userId, boolean isBorrow) {
        // 判断用户是否存在
        AssertUtils.asserter().assertNotNull(userMapper.selectByPrimaryKey(userId)).elseThrow(ErrorCodeEnum.USER_NOT_EXIST);
        // 查询记录
        return isBorrow ? shareRecordExtMapper.selectByBorrowUserId(userId) : shareRecordExtMapper.selectByShareUserId(userId);
    }

    /**
     * 修改共享记录状态，并记录共享日志，并更新书籍状态，并更新押金
     *
     * @param shareRecordId    共享记录ID
     * @param statusEnum       要修改的状态
     * @param operatorTypeEnum 发起人
     */
    public void updateShareRecordStatusAndRecordShareLogAndUpdateBookStatus(Long shareRecordId, ShareRecordStatusEnum statusEnum, OperatorTypeEnum operatorTypeEnum) {
        Objects.requireNonNull(shareRecordId);
        Objects.requireNonNull(statusEnum);
        Objects.requireNonNull(operatorTypeEnum);
        isExistShareRecord(shareRecordId);
        // 更新共享记录状态
        ShareRecord shareRecord = shareRecordMapper.selectByPrimaryKey(shareRecordId);
        ShareRecordStatusEnum oldStatusEnum = ShareRecordStatusEnum.getByCode(shareRecord.getRecordStatus());
        // 判断要修改的旧状态是否是新状态的父状态
        AssertUtils.asserter().assertTrue(statusEnum.getParentShareRecordStatus().equals(oldStatusEnum)).elseThrow(ErrorCodeEnum.SHARE_RECORD_STATUS_NOT_MATCH);
        shareRecord.setRecordStatus(statusEnum.getCode());
        // 更新共享记录
        shareRecordMapper.updateByPrimaryKey(shareRecord);
        // 插入共享日志
        ShareLog shareLog = new ShareLog();
        shareLog.setShareRecordId(shareRecordId);
        shareLog.setShareRecordStatus(statusEnum.getCode());
        shareLog.setOperatorType(operatorTypeEnum.getCode());
        shareLog.setGmtCreate(new Date());
        shareLogMapper.insertSelective(shareLog);
        // 更新书籍状态
        Long bookId = shareRecord.getBookId();
        Book book = bookMapper.selectByPrimaryKey(bookId);
        BookStatusEnum bookStatusEnum;
        switch (statusEnum) {
            // 归还,逾期归还,取消订单 更新为 空闲
            case RETURNED:
            case OVERDUE_RETURNED:
            case CANCEL_AFTER_ORDER:
                bookStatusEnum = BookStatusEnum.IDLE;
                break;
            // 已下单,借阅中 更新为 受理中
            case ORDER_HAS_BEEN_PLACED:
            case BORROWING:
                bookStatusEnum = BookStatusEnum.ACCEPTING;
                break;
            // 丢失或受损严重,严重逾期归还 更新为 异常
            case LOST_OR_DAMAGED:
            case SERIOUSLY_OVERDUE:
                bookStatusEnum = BookStatusEnum.ABNORMAL;
                break;
            default:
                throw new IllegalArgumentException("要修改的书籍状态不存在");
        }
        book.setBookStatus(bookStatusEnum.getCode());
        bookMapper.updateByPrimaryKeySelective(book);
        if (book.getBookDeposit() > 0) {
            // 押金处理
            updateDeposit(book.getBookDeposit(), shareRecord.getOrderNo(), statusEnum);
        }
    }

    private void updateDeposit(Long depositAmount, String innerOrderNo, ShareRecordStatusEnum statusEnum) {
        switch (statusEnum) {
            case ORDER_HAS_BEEN_PLACED:
                depositLogic.occupyDeposit(depositAmount, innerOrderNo);
                break;
            case BORROWING:
                break;
            case RETURNED:
            case OVERDUE_RETURNED:
            case CANCEL_AFTER_ORDER:
                depositLogic.releaseDeposit(depositAmount, innerOrderNo);
                break;
            case LOST_OR_DAMAGED:
            case SERIOUSLY_OVERDUE:
                depositLogic.payLossDeposit(depositAmount, innerOrderNo);
                depositLogic.compensation(depositAmount, innerOrderNo);
                break;
            default:
        }
    }
}
