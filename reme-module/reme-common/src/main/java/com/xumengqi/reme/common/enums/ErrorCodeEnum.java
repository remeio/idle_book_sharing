package com.xumengqi.reme.common.enums;

/**
 * 通用错误码
 * @author xumengqi
 * @date 2020/12/29 18:34
 */
public enum ErrorCodeEnum {
    SUCCESS(10000, "操作成功"),

    SQL_ERROR(-7, "数据库访问异常"),

    SYSTEM_ERROR(-6, "系统异常"),

    ILLEGAL_PARAMETER(-1, "参数错误"),

    NO_TOKEN(-7, "未携带token"),

    INVALID_TOKEN(-8, "无效的token或token已过期")
    ;
    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 信息描述
     */
    private final String message;

    ErrorCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
