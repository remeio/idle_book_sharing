package com.xumengqi.reme.dao.entity;

import java.io.Serializable;

public class ConfessionTag implements Serializable {
    /**
     * 表白标签ID
     *
     * @mbg.generated
     */
    private Long confessionTagId;

    /**
     * 表白标签名称
     *
     * @mbg.generated
     */
    private String confessionTagName;

    private static final long serialVersionUID = 1L;

    public Long getConfessionTagId() {
        return confessionTagId;
    }

    public void setConfessionTagId(Long confessionTagId) {
        this.confessionTagId = confessionTagId;
    }

    public String getConfessionTagName() {
        return confessionTagName;
    }

    public void setConfessionTagName(String confessionTagName) {
        this.confessionTagName = confessionTagName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", confessionTagId=").append(confessionTagId);
        sb.append(", confessionTagName=").append(confessionTagName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}