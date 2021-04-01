package com.xumengqi.reme.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class Feedback implements Serializable {
    /**
     * 主键
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 用户ID
     *
     * @mbg.generated
     */
    private Long userId;

    /**
     * 反馈内容
     *
     * @mbg.generated
     */
    private String feedbackContent;

    /**
     * 反馈关联订单
     *
     * @mbg.generated
     */
    private String feedbackOrder;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    public String getFeedbackOrder() {
        return feedbackOrder;
    }

    public void setFeedbackOrder(String feedbackOrder) {
        this.feedbackOrder = feedbackOrder;
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
        sb.append(", userId=").append(userId);
        sb.append(", feedbackContent=").append(feedbackContent);
        sb.append(", feedbackOrder=").append(feedbackOrder);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}