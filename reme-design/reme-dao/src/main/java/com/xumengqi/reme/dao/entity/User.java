package com.xumengqi.reme.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     * 用户ID
     *
     * @mbg.generated
     */
    private Long userId;

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
     * 学校ID
     *
     * @mbg.generated
     */
    private Long schoolId;

    /**
     * 用户姓名
     *
     * @mbg.generated
     */
    private String userName;

    /**
     * 用户专业
     *
     * @mbg.generated
     */
    private String major;

    /**
     * 用户届次
     *
     * @mbg.generated
     */
    private Integer grade;

    /**
     * 用户邮箱
     *
     * @mbg.generated
     */
    private String userMail;

    /**
     * 用户头像附件ID
     *
     * @mbg.generated
     */
    private Long avatarAttachId;

    /**
     * 用户性别
     *
     * @mbg.generated
     */
    private Integer sex;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public Long getAvatarAttachId() {
        return avatarAttachId;
    }

    public void setAvatarAttachId(Long avatarAttachId) {
        this.avatarAttachId = avatarAttachId;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
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
        sb.append(", userId=").append(userId);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", userPassword=").append(userPassword);
        sb.append(", schoolId=").append(schoolId);
        sb.append(", userName=").append(userName);
        sb.append(", major=").append(major);
        sb.append(", grade=").append(grade);
        sb.append(", userMail=").append(userMail);
        sb.append(", avatarAttachId=").append(avatarAttachId);
        sb.append(", sex=").append(sex);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}