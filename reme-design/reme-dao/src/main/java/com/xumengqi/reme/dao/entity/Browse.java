package com.xumengqi.reme.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class Browse implements Serializable {
    /**
     * 浏览ID
     *
     * @mbg.generated
     */
    private Long browseId;

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
     * 浏览用户ID
     *
     * @mbg.generated
     */
    private Long browseUserId;

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

    public Long getBrowseId() {
        return browseId;
    }

    public void setBrowseId(Long browseId) {
        this.browseId = browseId;
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

    public Long getBrowseUserId() {
        return browseUserId;
    }

    public void setBrowseUserId(Long browseUserId) {
        this.browseUserId = browseUserId;
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
        sb.append(", browseId=").append(browseId);
        sb.append(", targetType=").append(targetType);
        sb.append(", targetId=").append(targetId);
        sb.append(", browseUserId=").append(browseUserId);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}