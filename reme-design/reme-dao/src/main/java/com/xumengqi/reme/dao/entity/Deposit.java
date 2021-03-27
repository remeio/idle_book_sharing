package com.xumengqi.reme.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class Deposit implements Serializable {
    /**
     * 押金ID
     *
     * @mbg.generated
     */
    private Long depositId;

    /**
     * 押金订单号
     *
     * @mbg.generated
     */
    private String depositOrderNo;

    /**
     * 押金金额
     *
     * @mbg.generated
     */
    private Long depositAmount;

    /**
     * 操作类型：【1：缴纳，2：提取，3：占用押金，4：释放押金，5：支付损失，6：所得补偿】
     *
     * @mbg.generated
     */
    private Integer depositOperateType;

    /**
     * 用户ID
     *
     * @mbg.generated
     */
    private Long userId;

    /**
     * 内部订单号（关联支付损失和所得补偿）
     *
     * @mbg.generated
     */
    private String innerOrderNo;

    /**
     * 外部订单号（关联缴纳和提取）
     *
     * @mbg.generated
     */
    private String outerOrderNo;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date gmtCreate;

    private static final long serialVersionUID = 1L;

    public Long getDepositId() {
        return depositId;
    }

    public void setDepositId(Long depositId) {
        this.depositId = depositId;
    }

    public String getDepositOrderNo() {
        return depositOrderNo;
    }

    public void setDepositOrderNo(String depositOrderNo) {
        this.depositOrderNo = depositOrderNo;
    }

    public Long getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(Long depositAmount) {
        this.depositAmount = depositAmount;
    }

    public Integer getDepositOperateType() {
        return depositOperateType;
    }

    public void setDepositOperateType(Integer depositOperateType) {
        this.depositOperateType = depositOperateType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getInnerOrderNo() {
        return innerOrderNo;
    }

    public void setInnerOrderNo(String innerOrderNo) {
        this.innerOrderNo = innerOrderNo;
    }

    public String getOuterOrderNo() {
        return outerOrderNo;
    }

    public void setOuterOrderNo(String outerOrderNo) {
        this.outerOrderNo = outerOrderNo;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", depositId=").append(depositId);
        sb.append(", depositOrderNo=").append(depositOrderNo);
        sb.append(", depositAmount=").append(depositAmount);
        sb.append(", depositOperateType=").append(depositOperateType);
        sb.append(", userId=").append(userId);
        sb.append(", innerOrderNo=").append(innerOrderNo);
        sb.append(", outerOrderNo=").append(outerOrderNo);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}