package com.xumengqi.reme.dao.entity;

import java.io.Serializable;

public class City implements Serializable {
    /**
     * 市级ID
     *
     * @mbg.generated
     */
    private Long cityId;

    /**
     * 市级名称
     *
     * @mbg.generated
     */
    private String cityName;

    /**
     * 省级ID
     *
     * @mbg.generated
     */
    private Long provinceId;

    private static final long serialVersionUID = 1L;

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cityId=").append(cityId);
        sb.append(", cityName=").append(cityName);
        sb.append(", provinceId=").append(provinceId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}