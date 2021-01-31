package com.xumengqi.reme.common.enums;

/**
 * 通用错误码
 * @author xumengqi
 * @date 2020/12/29 18:34
 */
public enum ErrorCodeEnum {
    SUCCESS(10000, "操作成功"),

    VERIFICATION_CODE_SEND_SUCCESS(10001, "验证码发送成功"),

    VERIFICATION_CODE_PASS(10002, "验证通过"),


    SYSTEM_ERROR(-6, "系统异常"),

    ILLEGAL_PARAMETER(-1, "参数错误"),

    VERIFICATION_CODE_HAD_SENT(-2, "验证码已发送，请稍后重试"),

    VERIFICATION_CODE_HAD_EXPIRED(-3, "验证码已过期"),

    VERIFICATION_CODE_SEND_FAILURE(-4, "验证码发送失败"),

    VERIFICATION_CODE_NOT_PASS(-5, "验证码错误"),
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
