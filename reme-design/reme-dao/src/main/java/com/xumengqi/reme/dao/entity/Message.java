package com.xumengqi.reme.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    /**
     * 主键
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 消息内容
     *
     * @mbg.generated
     */
    private String messageContent;

    /**
     * 共享记录ID
     *
     * @mbg.generated
     */
    private Long shareRecordId;

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

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Long getShareRecordId() {
        return shareRecordId;
    }

    public void setShareRecordId(Long shareRecordId) {
        this.shareRecordId = shareRecordId;
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
        sb.append(", messageContent=").append(messageContent);
        sb.append(", shareRecordId=").append(shareRecordId);
        sb.append(", operatorType=").append(operatorType);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}