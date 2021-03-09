package com.xumengqi.reme.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class Confession implements Serializable {
    /**
     * 表白ID
     *
     * @mbg.generated
     */
    private Long confessionId;

    /**
     * 表白标题
     *
     * @mbg.generated
     */
    private String confessionTitle;

    /**
     * 表白详情
     *
     * @mbg.generated
     */
    private String confessionDetail;

    /**
     * 表白是否匿名
     *
     * @mbg.generated
     */
    private Integer isAnonymous;

    /**
     * 表白标签ID
     *
     * @mbg.generated
     */
    private Long confessionTagId;

    /**
     * 表白位置
     *
     * @mbg.generated
     */
    private String confessionLocation;

    /**
     * 表白是否解决
     *
     * @mbg.generated
     */
    private Integer isSolved;

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

    /**
     * 修改时间
     *
     * @mbg.generated
     */
    private Date gmtModified;

    private static final long serialVersionUID = 1L;

    public Long getConfessionId() {
        return confessionId;
    }

    public void setConfessionId(Long confessionId) {
        this.confessionId = confessionId;
    }

    public String getConfessionTitle() {
        return confessionTitle;
    }

    public void setConfessionTitle(String confessionTitle) {
        this.confessionTitle = confessionTitle;
    }

    public String getConfessionDetail() {
        return confessionDetail;
    }

    public void setConfessionDetail(String confessionDetail) {
        this.confessionDetail = confessionDetail;
    }

    public Integer getIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(Integer isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public Long getConfessionTagId() {
        return confessionTagId;
    }

    public void setConfessionTagId(Long confessionTagId) {
        this.confessionTagId = confessionTagId;
    }

    public String getConfessionLocation() {
        return confessionLocation;
    }

    public void setConfessionLocation(String confessionLocation) {
        this.confessionLocation = confessionLocation;
    }

    public Integer getIsSolved() {
        return isSolved;
    }

    public void setIsSolved(Integer isSolved) {
        this.isSolved = isSolved;
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
        sb.append(", confessionId=").append(confessionId);
        sb.append(", confessionTitle=").append(confessionTitle);
        sb.append(", confessionDetail=").append(confessionDetail);
        sb.append(", isAnonymous=").append(isAnonymous);
        sb.append(", confessionTagId=").append(confessionTagId);
        sb.append(", confessionLocation=").append(confessionLocation);
        sb.append(", isSolved=").append(isSolved);
        sb.append(", userId=").append(userId);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}