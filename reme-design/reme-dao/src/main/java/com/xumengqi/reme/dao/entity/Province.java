package com.xumengqi.reme.dao.entity;

import java.io.Serializable;

public class Province implements Serializable {
    /**
     * 省级ID
     *
     * @mbg.generated
     */
    private Long provinceId;

    /**
     * 省级名称
     *
     * @mbg.generated
     */
    private String provinceName;

    private static final long serialVersionUID = 1L;

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", provinceId=").append(provinceId);
        sb.append(", provinceName=").append(provinceName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}