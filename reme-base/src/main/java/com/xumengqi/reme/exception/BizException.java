package com.xumengqi.reme.exception;

import com.xumengqi.reme.enums.ErrorCodeEnum;

/**
 * @author xumengqi
 * @date 2021/1/2 20:23
 */
public class BizException extends RuntimeException {

    private final Integer errorNo;

    private final String errorInfo;

    public BizException(Integer errorNo, String errorInfo) {
        super(errorInfo);
        this.errorNo = errorNo;
        this.errorInfo = errorInfo;
    }

    public Integer getErrorNo() {
        return errorNo;
    }


    public String getErrorInfo() {
        return errorInfo;
    }

    public static void error(ErrorCodeEnum errorCodeEnum, Object... args) {
        throw new BizException(errorCodeEnum.getCode(), String.format(errorCodeEnum.getMessage(), args));
    }
}
