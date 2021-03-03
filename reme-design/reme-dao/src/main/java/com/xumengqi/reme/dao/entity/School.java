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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", schoolId=").append(schoolId);
        sb.append(", schoolName=").append(schoolName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}