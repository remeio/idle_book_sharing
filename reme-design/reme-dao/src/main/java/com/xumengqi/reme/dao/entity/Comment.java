package com.xumengqi.reme.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
    /**
     * 评论ID
     *
     * @mbg.generated
     */
    private Long commentId;

    /**
     * 目标类型
     *
     * @mbg.generated
     */
    private Byte targetType;

    /**
     * 目标ID
     *
     * @mbg.generated
     */
    private Long targetId;

    /**
     * 评论内容
     *
     * @mbg.generated
     */
    private String commentContent;

    /**
     * 是否匿名
     *
     * @mbg.generated
     */
    private Byte isAnonymous;

    /**
     * 评论人ID
     *
     * @mbg.generated
     */
    private Long fromUserId;

    /**
     * 附件编码
     *
     * @mbg.generated
     */
    private Long attachId;

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

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Byte getTargetType() {
        return targetType;
    }

    public void setTargetType(Byte targetType) {
        this.targetType = targetType;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Byte getIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(Byte isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public Long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Long getAttachId() {
        return attachId;
    }

    public void setAttachId(Long attachId) {
        this.attachId = attachId;
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
        sb.append(", commentId=").append(commentId);
        sb.append(", targetType=").append(targetType);
        sb.append(", targetId=").append(targetId);
        sb.append(", commentContent=").append(commentContent);
        sb.append(", isAnonymous=").append(isAnonymous);
        sb.append(", fromUserId=").append(fromUserId);
        sb.append(", attachId=").append(attachId);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}