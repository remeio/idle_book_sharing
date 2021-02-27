package com.xumengqi.reme.dao.entity;

import java.io.Serializable;

public class SchoolMap implements Serializable {
    /**
     * 学校地图ID
     *
     * @mbg.generated
     */
    private Long schoolMapId;

    /**
     * 学校地图附件ID
     *
     * @mbg.generated
     */
    private Long map;

    private static final long serialVersionUID = 1L;

    public Long getSchoolMapId() {
        return schoolMapId;
    }

    public void setSchoolMapId(Long schoolMapId) {
        this.schoolMapId = schoolMapId;
    }

    public Long getMap() {
        return map;
    }

    public void setMap(Long map) {
        this.map = map;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", schoolMapId=").append(schoolMapId);
        sb.append(", map=").append(map);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}