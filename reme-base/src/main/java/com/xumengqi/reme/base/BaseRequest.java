package com.xumengqi.reme.base;

import com.google.gson.Gson;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author xumengqi
 * @date 2020/12/28 19:26
 */
public class BaseRequest {
    @ApiModelProperty(value = "操作人编码", hidden = true)
    private String operatorCode;

    @ApiModelProperty(value = "操作人 IP", hidden = true)
    private String ipAddress;

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
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
