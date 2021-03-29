package com.xumengqi.reme.api.deposit.dto;

import com.xumengqi.reme.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author xumengqi
 * @date 2021/3/29 19:30
 */
@Getter
@Setter
public class DepositDTO extends BaseDTO {
    /**
     * 押金ID
     */
    private Long depositId;

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
}
