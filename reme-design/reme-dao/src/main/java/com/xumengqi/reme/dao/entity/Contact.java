package com.xumengqi.reme.dao.entity;

import java.io.Serializable;

public class Contact implements Serializable {
    /**
     * 联系人ID
     *
     * @mbg.generated
     */
    private Long contactId;

    /**
     * 联系人名称
     *
     * @mbg.generated
     */
    private String contactName;

    /**
     * 手机号码
     *
     * @mbg.generated
     */
    private String contactPhone;

    /**
     * 邮箱
     *
     * @mbg.generated
     */
    private String contactMail;

    /**
     * 地址
     *
     * @mbg.generated
     */
    private String contactAddress;

    /**
     * 头像
     *
     * @mbg.generated
     */
    private Long avatarAttachId;

    private static final long serialVersionUID = 1L;

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactMail() {
        return contactMail;
    }

    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public Long getAvatarAttachId() {
        return avatarAttachId;
    }

    public void setAvatarAttachId(Long avatarAttachId) {
        this.avatarAttachId = avatarAttachId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", contactId=").append(contactId);
        sb.append(", contactName=").append(contactName);
        sb.append(", contactPhone=").append(contactPhone);
        sb.append(", contactMail=").append(contactMail);
        sb.append(", contactAddress=").append(contactAddress);
        sb.append(", avatarAttachId=").append(avatarAttachId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}