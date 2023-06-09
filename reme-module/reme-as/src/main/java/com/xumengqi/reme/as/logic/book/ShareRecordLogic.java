package com.xumengqi.reme.as.logic.book;

import com.xumengqi.reme.as.vo.RankVO;
import com.xumengqi.reme.as.vo.ShareRecordVO;
import com.xumengqi.reme.dao.entity.Message;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/3/26 19:24
 */
public interface ShareRecordLogic {
    /**
     * 借阅者借阅书籍
     *
     * @param bookId       /
     * @param borrowUserId /
     */
    void borrowBook(Long bookId, Long borrowUserId);


    /**
     * 借阅者收到书籍
     *
     * @param shareRecordId /
     * @param borrowUserId  /
     */
    void receiveBook(Long shareRecordId, Long borrowUserId);

    /**
     * 共享者收到书籍
     *
     * @param shareRecordId /
     * @param shareUserId   /
     */
    void returnBook(Long shareRecordId, Long shareUserId);

    /**
     * 借阅者或共享者取消订单
     *
     * @param shareRecordId /
     * @param userId        /
     */
    void cancelBorrowBook(Long shareRecordId, Long userId);

    /**
     * 丢失书籍处理 (共享者或借阅者均可处理)
     *
     * @param shareRecordId /
     * @param userId        /
     */
    void lostHandleBook(Long shareRecordId, Long userId);

    /**
     * 共享者严重逾期处理书籍
     *
     * @param shareRecordId /
     * @param shareUserId   /
     */
    void seriouslyOverdueHandleBook(Long shareRecordId, Long shareUserId);


    /**
     * 判断共享记录是否存在
     *
     * @param shareRecordId /
     */
    void isExistShareRecord(Long shareRecordId);

    /**
     * 判断共享记录和借阅者是否匹配
     *
     * @param shareRecordId /
     * @param borrowUserId  /
     */
    void isBorrowUser(Long shareRecordId, Long borrowUserId);

    /**
     * 判断共享记录和共享者是否匹配
     *
     * @param shareRecordId /
     * @param shareUserId   /
     */
    void isShareUser(Long shareRecordId, Long shareUserId);

    /**
     * 根据借阅者ID获取共享记录列表
     *
     * @param userId /
     * @return /
     */
    List<ShareRecordVO> getShareRecordListByBorrowUserId(Long userId);

    /**
     * 根据共享者ID获取共享记录列表
     *
     * @param userId /
     * @return /
     */
    List<ShareRecordVO> getShareRecordListByShareUserId(Long userId);


    /**
     * 查询共享记录（VO）
     *
     * @param shareRecordId /
     * @return /
     */
    ShareRecordVO getShareRecord(Long shareRecordId);

    /**
     * 获取借阅排行榜
     * @param i 取多少
     * @return /
     */
    List<RankVO> getBorrowRankList(int i);

    /**
     * 获取共享排行榜
     * @param i 取多少
     * @return /
     */
    List<RankVO> getShareRankList(int i);

    /**
     * 发送消息
     * @param userId /
     * @param shareRecordId /
     * @param messageContent /
     */
    void sendMessage(Long userId, Long shareRecordId, String messageContent);

    /**
     * 获取消息列表
     * @param userId /
     * @param shareRecordId /
     * @return /
     */
    List<Message> getMessageList(Long userId, Long shareRecordId);

    /**
     * 评分
     * @param shareRecordId /
     * @param score /
     * @param borrowUserId /
     */
    void score(Long shareRecordId, Double score, Long borrowUserId);

    /**
     * 获取书籍评分
     * @param bookId /
     * @return /
     */
    Double getScoreOfBook(Long bookId);
}
