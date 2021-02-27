package com.xumengqi.reme.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class Reply implements Serializable {
    /**
     * 回复ID
     *
     * @mbg.generated
     */
    private Long replyId;

    /**
     * 评论ID
     *
     * @mbg.generated
     */
    private Long commentId;

    /**
     * 回复内容
     *
     * @mbg.generated
     */
    private String replyContent;

    /**
     * 回复用户ID
     *
     * @mbg.generated
     */
    private Long fromUserId;

    /**
     * 目标用户ID
     *
     * @mbg.generated
     */
    private Long toUserId;

    /**
     * 是否匿名
     *
     * @mbg.generated
     */
    private Byte isAnonymous;

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

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
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

    public Byte getIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(Byte isAnonymous) {
        this.isAnonymous = isAnonymous;
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
        sb.append(", replyId=").append(replyId);
        sb.append(", commentId=").append(commentId);
        sb.append(", replyContent=").append(replyContent);
        sb.append(", fromUserId=").append(fromUserId);
        sb.append(", toUserId=").append(toUserId);
        sb.append(", isAnonymous=").append(isAnonymous);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}