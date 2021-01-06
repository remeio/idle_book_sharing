package com.xumengqi.reme.base;

import com.google.gson.Gson;
import com.xumengqi.reme.enums.ErrorCodeEnum;

/**
 * @author xumengqi
 * @date 2020/12/28 19:26
 */
public class BaseResponse {

    private Integer errorNo;

    private String errorInfo;

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

    public void success(ErrorCodeEnum errorCodeEnum, Object... args) {
        setErrorNo(ErrorCodeEnum.SUCCESS.getCode());
        setErrorInfo(String.format(errorCodeEnum.getMessage(), args));
    }

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