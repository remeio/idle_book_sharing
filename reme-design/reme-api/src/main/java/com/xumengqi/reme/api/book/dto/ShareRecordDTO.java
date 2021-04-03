package com.xumengqi.reme.api.book.dto;

import com.xumengqi.reme.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author xumengqi
 * @date 2021/3/27 19:27
 */
@Getter
@Setter
public class ShareRecordDTO extends BaseDTO {
    /**
     * 共享记录ID
     */
    private Long id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 书籍ID
     */
    private Long bookId;

    /**
     * 共享者ID
     */
    private Long shareUserId;

    /**
     * 借阅者ID
     */
    private Long borrowUserId;

    /**
     * 共享记录状态【1：已下单，2：借阅中，3：已归还，4：逾期归还，5：下单后取消，6：书籍丢失或严重受损，7：书籍超时严重不归还】
     */
    private Integer recordStatus;

    /**
     * 评分【1，1.5，2，2.5，3，3.5，4，4.5，5】
     *
     * @mbg.generated
     */
    private Double score;

    /**
     * 创建时间
     */
    private Date gmtCreate;


    // CUSTOM
    /**
     * 书籍名称
     */
    private String bookName;

    /**
     * 书籍借出最大周期
     */
    private Integer bookMaxPeriod;

    /**
     * 书籍所需押金
     */
    private Long bookDeposit;

    /**
     * 书籍图片URL
     */
    private String bookImageUrl;
}
