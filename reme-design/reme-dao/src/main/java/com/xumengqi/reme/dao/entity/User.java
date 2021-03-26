package com.xumengqi.reme.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     * 用户ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 用户手机号
     *
     * @mbg.generated
     */
    private String userPhone;

    /**
     * 用户密码
     *
     * @mbg.generated
     */
    private String userPassword;

    /**
     * 用户姓名
     *
     * @mbg.generated
     */
    private String userFullName;

    /**
     * 学校ID
     *
     * @mbg.generated
     */
    private Long schoolId;

    /**
     * 可用押金
     *
     * @mbg.generated
     */
    private Long canUseDeposit;

    /**
     * 占用押金
     *
     * @mbg.generated
     */
    private Long occupyDeposit;

    /**
     * 支付损失押金
     *
     * @mbg.generated
     */
    private Long lossDeposit;

    /**
     * 所得补偿押金
     *
     * @mbg.generated
     */
    private Long makeUpDeposit;

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

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public Long getCanUseDeposit() {
        return canUseDeposit;
    }

    public void setCanUseDeposit(Long canUseDeposit) {
        this.canUseDeposit = canUseDeposit;
    }

    public Long getOccupyDeposit() {
        return occupyDeposit;
    }

    public void setOccupyDeposit(Long occupyDeposit) {
        this.occupyDeposit = occupyDeposit;
    }

    public Long getLossDeposit() {
        return lossDeposit;
    }

    public void setLossDeposit(Long lossDeposit) {
        this.lossDeposit = lossDeposit;
    }

    public Long getMakeUpDeposit() {
        return makeUpDeposit;
    }

    public void setMakeUpDeposit(Long makeUpDeposit) {
        this.makeUpDeposit = makeUpDeposit;
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
        sb.append(", userPhone=").append(userPhone);
        sb.append(", userPassword=").append(userPassword);
        sb.append(", userFullName=").append(userFullName);
        sb.append(", schoolId=").append(schoolId);
        sb.append(", canUseDeposit=").append(canUseDeposit);
        sb.append(", occupyDeposit=").append(occupyDeposit);
        sb.append(", lossDeposit=").append(lossDeposit);
        sb.append(", makeUpDeposit=").append(makeUpDeposit);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}