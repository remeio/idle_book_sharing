package com.xumengqi.reme.as.vo;

import com.xumengqi.reme.base.BaseVO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author xumengqi
 * @date 2021/3/29 19:30
 */
@Getter
@Setter
public class DepositVO extends BaseVO {
    /**
     * 押金ID
     */
    private Long id;

    /**
     * 押金订单号
     */
    private String depositOrderNo;

    /**
     * 押金金额
     */
    private Long depositAmount;

    /**
     * 操作类型：【1：缴纳，2：提取，3：占用押金，4：释放押金，5：支付损失，6：所得补偿】
     */
    private Integer depositOperateType;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 内部订单号（关联支付损失和所得补偿）
     */
    private String innerOrderNo;

    /**
     * 外部订单号（关联缴纳和提取）
     */
    private String outerOrderNo;

    /**
     * 创建时间
     */
    private Date gmtCreate;


    // CUSTOM
    /**
     * 书籍名称（如果有的话）
     */
    private String bookName;
}
