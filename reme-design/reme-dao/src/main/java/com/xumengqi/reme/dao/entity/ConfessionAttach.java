package com.xumengqi.reme.dao.entity;

import java.io.Serializable;

public class ConfessionAttach implements Serializable {
    /**
     * 表白ID
     *
     * @mbg.generated
     */
    private Long confessionId;

    /**
     * 附件ID
     *
     * @mbg.generated
     */
    private Long attachId;

    /**
     * 附件排序
     *
     * @mbg.generated
     */
    private Integer attachOrder;

    private static final long serialVersionUID = 1L;

    public Long getConfessionId() {
        return confessionId;
    }

    public void setConfessionId(Long confessionId) {
        this.confessionId = confessionId;
    }

    public Long getAttachId() {
        return attachId;
    }

    public void setAttachId(Long attachId) {
        this.attachId = attachId;
    }

    public Integer getAttachOrder() {
        return attachOrder;
    }

    public void setAttachOrder(Integer attachOrder) {
        this.attachOrder = attachOrder;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", confessionId=").append(confessionId);
        sb.append(", attachId=").append(attachId);
        sb.append(", attachOrder=").append(attachOrder);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}