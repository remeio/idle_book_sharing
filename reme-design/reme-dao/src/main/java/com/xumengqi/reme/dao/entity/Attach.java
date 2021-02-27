package com.xumengqi.reme.dao.entity;

import java.io.Serializable;

public class Attach implements Serializable {
    /**
     * 附件ID
     *
     * @mbg.generated
     */
    private Long attachId;

    /**
     * 附件完整路径
     *
     * @mbg.generated
     */
    private String attachFullPath;

    private static final long serialVersionUID = 1L;

    public Long getAttachId() {
        return attachId;
    }

    public void setAttachId(Long attachId) {
        this.attachId = attachId;
    }

    public String getAttachFullPath() {
        return attachFullPath;
    }

    public void setAttachFullPath(String attachFullPath) {
        this.attachFullPath = attachFullPath;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", attachId=").append(attachId);
        sb.append(", attachFullPath=").append(attachFullPath);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}