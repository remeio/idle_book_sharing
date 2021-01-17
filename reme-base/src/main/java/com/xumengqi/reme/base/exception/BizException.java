package com.xumengqi.reme.base.exception;

import com.xumengqi.reme.common.enums.ErrorCodeEnum;

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

    /**
     * 抛出异常
     * @param errorCodeEnum 错误码
     * @param args 内嵌参数
     */
    public static void error(ErrorCodeEnum errorCodeEnum, Object... args) {
        throw new BizException(errorCodeEnum.getCode(), String.format(errorCodeEnum.getMessage(), args));
    }
}
