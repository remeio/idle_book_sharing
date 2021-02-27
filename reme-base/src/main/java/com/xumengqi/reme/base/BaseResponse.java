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

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public BaseResponse() {
        // 创建即代表成功
        error(ErrorCodeEnum.SUCCESS);
    }

    public Integer getErrorNo() {
        return errorNo;
    }

    public void setErrorNo(Integer errorNo) {
        this.errorNo = errorNo;
        this.success = ErrorCodeEnum.isSuccessFor(errorNo);
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
     * @param errorCodeEnum 错误码
     * @param args          内嵌参数
     */
    public void error(ErrorCodeEnum errorCodeEnum, Object... args) {
        setErrorNo(errorCodeEnum.getFullCode());
        setErrorInfo(String.format(errorCodeEnum.getMessage(), args));
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}