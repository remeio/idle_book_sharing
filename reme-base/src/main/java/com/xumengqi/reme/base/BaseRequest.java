package com.xumengqi.reme.base;

import com.google.gson.Gson;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author xumengqi
 * @date 2020/12/28 19:26
 */
public class BaseRequest {
    @ApiModelProperty(value = "操作人 ID", hidden = true)
    private Long operatorId;

    @ApiModelProperty(value = "操作人 IP", hidden = true)
    private String ipAddress;

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
