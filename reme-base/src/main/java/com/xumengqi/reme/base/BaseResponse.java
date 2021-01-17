package com.xumengqi.reme.base;

import com.google.gson.Gson;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author xumengqi
 * @date 2020/12/28 19:26
 */
public class BaseResponse {
    @ApiModelProperty("错误码")
    private Integer errorNo;

    @ApiModelProperty("错误信息")
    private String errorInfo;

    @ApiModelProperty("成功与否")
    private boolean success;

    public Integer getErrorNo() {
        return errorNo;
    }

    public void setErrorNo(Integer errorNo) {
        this.errorNo = errorNo;
        this.success =  ErrorCodeEnum.SUCCESS.getCode().equals(errorNo);
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    /**
     * 视为成功
     * @param errorCodeEnum 错误码
     * @param args 内嵌参数
     */
    public void success(ErrorCodeEnum errorCodeEnum, Object... args) {
        setErrorNo(ErrorCodeEnum.SUCCESS.getCode());
        setErrorInfo(String.format(errorCodeEnum.getMessage(), args));
    }

    /**
     * 视为失败
     * @param errorCodeEnum 错误码
     * @param args 内嵌参数
     */
    public void failure(ErrorCodeEnum errorCodeEnum, Object... args) {
        setErrorNo(errorCodeEnum.getCode());
        setErrorInfo(String.format(errorCodeEnum.getMessage(), args));
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}