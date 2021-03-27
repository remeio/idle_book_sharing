package com.xumengqi.reme.as.logic.book;

import com.xumengqi.reme.as.vo.ShareRecordVO;

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
     * 共享者收到书籍 (逾期)
     *
     * @param shareRecordId /
     * @param shareUserId   /
     */
    void overdueReturnBook(Long shareRecordId, Long shareUserId);

    /**
     * 借阅者取消订单
     *
     * @param shareRecordId /
     * @param borrowUserId  /
     */
    void cancelBorrowBook(Long shareRecordId, Long borrowUserId);

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
}
