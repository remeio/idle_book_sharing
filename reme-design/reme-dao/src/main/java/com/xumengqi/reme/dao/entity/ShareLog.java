package com.xumengqi.reme.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class ShareLog implements Serializable {
    /**
     * 共享日志ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 共享记录ID
     *
     * @mbg.generated
     */
    private Long shareRecordId;

    /**
     * 共享记录状态【1：已下单，2：借阅中，3：已归还，4：逾期归还，5：下单后取消，6：书籍丢失或严重受损，7：书籍超时严重不归还】
     *
     * @mbg.generated
     */
    private Integer shareRecordStatus;

    /**
     * 操作人类型【1：共享者，2：借阅者】
     *
     * @mbg.generated
     */
    private Integer operatorType;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date gmtCreate;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShareRecordId() {
        return shareRecordId;
    }

    public void setShareRecordId(Long shareRecordId) {
        this.shareRecordId = shareRecordId;
    }

    public Integer getShareRecordStatus() {
        return shareRecordStatus;
    }

    public void setShareRecordStatus(Integer shareRecordStatus) {
        this.shareRecordStatus = shareRecordStatus;
    }

    public Integer getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
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
        sb.append(", id=").append(id);
        sb.append(", shareRecordId=").append(shareRecordId);
        sb.append(", shareRecordStatus=").append(shareRecordStatus);
        sb.append(", operatorType=").append(operatorType);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}