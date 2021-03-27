package com.xumengqi.reme.as.vo;

import com.xumengqi.reme.base.BaseVO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author xumengqi
 * @date 2021/3/27 20:01
 */
@Getter
@Setter
public class ShareRecordVO extends BaseVO {
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
