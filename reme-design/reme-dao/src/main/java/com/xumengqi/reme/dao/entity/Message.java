package com.xumengqi.reme.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    /**
     * 消息ID
     *
     * @mbg.generated
     */
    private Long messageId;

    /**
     * 消息内容
     *
     * @mbg.generated
     */
    private String messageContent;

    /**
     * 附件ID
     *
     * @mbg.generated
     */
    private Long attachId;

    /**
     * 发送方ID
     *
     * @mbg.generated
     */
    private Long fromUserId;

    /**
     * 接收方ID
     *
     * @mbg.generated
     */
    private Long toUserId;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date gmtCreate;

    /**
     * 修改时间
     *
     * @mbg.generated
     */
    private Date gmtModified;

    private static final long serialVersionUID = 1L;

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Long getAttachId() {
        return attachId;
    }

    public void setAttachId(Long attachId) {
        this.attachId = attachId;
    }

    public Long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", messageId=").append(messageId);
        sb.append(", messageContent=").append(messageContent);
        sb.append(", attachId=").append(attachId);
        sb.append(", fromUserId=").append(fromUserId);
        sb.append(", toUserId=").append(toUserId);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}