package com.xumengqi.reme.as.logic.book.impl;

import com.xumengqi.reme.as.logic.book.ShareRecordLogic;
import com.xumengqi.reme.as.logic.deposit.DepositLogic;
import com.xumengqi.reme.base.BizException;
import com.xumengqi.reme.base.util.AssertUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import com.xumengqi.reme.common.enums.biz.BookStatusEnum;
import com.xumengqi.reme.common.enums.biz.OperatorTypeEnum;
import com.xumengqi.reme.common.enums.biz.ShareRecordStatusEnum;
import com.xumengqi.reme.dao.entity.Book;
import com.xumengqi.reme.dao.entity.ShareLog;
import com.xumengqi.reme.dao.entity.ShareRecord;
import com.xumengqi.reme.dao.entity.User;
import com.xumengqi.reme.dao.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * @author xumengqi
 * @date 2021/3/26 19:52
 */
@Component
public class ShareRecordLogicImpl implements ShareRecordLogic {
    @Autowired
    private DepositMapper depositMapper;

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
        // 创建共享记录，初始状态为初始化
        ShareRecord shareRecord = new ShareRecord();
        shareRecord.setOrderNo(UUID.randomUUID().toString());
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
        updateShareRecordStatusAndRecordShareLogAndUpdateBookStatus(shareRecordId, ShareRecordStatusEnum.RETURNED, OperatorTypeEnum.SHARER);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void overdueReturnBook(Long shareRecordId, Long shareUserId) {
        isShareUser(shareRecordId, shareUserId);
        updateShareRecordStatusAndRecordShareLogAndUpdateBookStatus(shareRecordId, ShareRecordStatusEnum.OVERDUE_RETURNED, OperatorTypeEnum.SHARER);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void cancelBorrowBook(Long shareRecordId, Long borrowUserId) {
        isBorrowUser(shareRecordId, borrowUserId);
        updateShareRecordStatusAndRecordShareLogAndUpdateBookStatus(shareRecordId, ShareRecordStatusEnum.CANCEL_AFTER_ORDER, OperatorTypeEnum.BORROWER);
    }


    @Override
    public void lostHandleBook(Long shareRecordId, Long userId) {
        isExistShareRecord(shareRecordId);
        ShareRecord shareRecord = shareRecordMapper.selectByPrimaryKey(shareRecordId);
        OperatorTypeEnum operatorTypeEnum = null;
        if (shareRecord.getShareUserId().equals(userId)) {
            operatorTypeEnum = OperatorTypeEnum.SHARER;
        } else if (shareRecord.getBorrowUserId().equals(userId)) {
            operatorTypeEnum = OperatorTypeEnum.SHARER;
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
