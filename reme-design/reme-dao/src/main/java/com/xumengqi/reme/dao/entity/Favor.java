package com.xumengqi.reme.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class Favor implements Serializable {
    /**
     * 点赞ID
     *
     * @mbg.generated
     */
    private Long favorId;

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
     * 点赞用户ID
     *
     * @mbg.generated
     */
    private Long userId;

    /**
     * 点赞状态
     *
     * @mbg.generated
     */
    private Byte status;

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

    public Long getFavorId() {
        return favorId;
    }

    public void setFavorId(Long favorId) {
        this.favorId = favorId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
        sb.append(", favorId=").append(favorId);
        sb.append(", targetType=").append(targetType);
        sb.append(", targetId=").append(targetId);
        sb.append(", userId=").append(userId);
        sb.append(", status=").append(status);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}