package com.xumengqi.reme.dao.entity;

import java.io.Serializable;

public class School implements Serializable {
    /**
     * 学校ID
     *
     * @mbg.generated
     */
    private Long schoolId;

    /**
     * 学校名称
     *
     * @mbg.generated
     */
    private String schoolName;

    /**
     * 办学层次
     *
     * @mbg.generated
     */
    private Byte schoolLevel;

    /**
     * 城市ID
     *
     * @mbg.generated
     */
    private Long cityId;

    private static final long serialVersionUID = 1L;

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Byte getSchoolLevel() {
        return schoolLevel;
    }

    public void setSchoolLevel(Byte schoolLevel) {
        this.schoolLevel = schoolLevel;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", schoolId=").append(schoolId);
        sb.append(", schoolName=").append(schoolName);
        sb.append(", schoolLevel=").append(schoolLevel);
        sb.append(", cityId=").append(cityId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}