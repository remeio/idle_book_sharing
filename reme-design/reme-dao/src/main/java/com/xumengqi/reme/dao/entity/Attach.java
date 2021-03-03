package com.xumengqi.reme.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class Attach implements Serializable {
    /**
     * 附件ID
     *
     * @mbg.generated
     */
    private Long attachId;

    /**
     * 附件完整路径
     *
     * @mbg.generated
     */
    private String attachFullPath;

    /**
     * 附件名称
     *
     * @mbg.generated
     */
    private String attachName;

    /**
     * 用户ID
     *
     * @mbg.generated
     */
    private Long userId;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date gmtCreate;

    private static final long serialVersionUID = 1L;

    public Long getAttachId() {
        return attachId;
    }

    public void setAttachId(Long attachId) {
        this.attachId = attachId;
    }

    public String getAttachFullPath() {
        return attachFullPath;
    }

    public void setAttachFullPath(String attachFullPath) {
        this.attachFullPath = attachFullPath;
    }

    public String getAttachName() {
        return attachName;
    }

    public void setAttachName(String attachName) {
        this.attachName = attachName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
        sb.append(", attachId=").append(attachId);
        sb.append(", attachFullPath=").append(attachFullPath);
        sb.append(", attachName=").append(attachName);
        sb.append(", userId=").append(userId);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}