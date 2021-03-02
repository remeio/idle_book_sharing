package com.xumengqi.reme.common.enums;

import com.sun.org.apache.xpath.internal.operations.Mod;

/**
 * 通用错误码
 *
 * @author xumengqi
 * @date 2020/12/29 18:34
 */
public enum ErrorCodeEnum {
    // SYSTEM
    /**
     * 操作成功
     */
    SUCCESS(ModuleEnum.SYSTEM, 100, "操作成功"),

    /**
     * 系统异常
     */
    SYSTEM_ERROR(ModuleEnum.SYSTEM, 500, "系统异常"),

    /**
     * 数据库访问异常
     */
    SQL_ERROR(ModuleEnum.SYSTEM, 501, "数据库访问异常"),

    /**
     * 参数错误
     */
    ILLEGAL_PARAMETER(ModuleEnum.SYSTEM, 502, "参数错误"),

    /**
     * 未携带token
     */
    NO_TOKEN(ModuleEnum.SYSTEM, 503, "未携带token"),

    /**
     * 无效的token或token已过期
     */
    INVALID_TOKEN(ModuleEnum.SYSTEM, 504, "无效的token或token已过期"),

    // USER
    /**
     * 该手机号已被注册
     */
    THE_PHONE_NUMBER_HAS_BEEN_REGISTERED(ModuleEnum.USER, 501, "该手机号已被注册"),

    /**
     * 密码错误
     */
    WRONG_PASSWORD(ModuleEnum.USER, 502, "密码错误"),

    /**
     * 该用户不存在
     */
    USER_NOT_EXISTS(ModuleEnum.USER, 503, "该用户不存在"),

    // SCHOOL
    /**
     * 学校不存在
     */
    SCHOOL_NOT_EXIST(ModuleEnum.SCHOOL, 501, "学校不存在"),

    // VERIFICATION_CODE
    /**
     * 不支持的验证码类型
     */
    UNSUPPORTED_VERIFICATION_CODE_TYPE(ModuleEnum.VERIFICATION_CODE, 501, "不支持的验证码类型"),
    /**
     * 验证码发送失败
     */
    VERIFICATION_CODE_SEND_FAIL(ModuleEnum.VERIFICATION_CODE, 502, "验证码发送失败"),
    /**
     * 验证码已发送
     */
    VERIFICATION_CODE_HAD_SENT(ModuleEnum.VERIFICATION_CODE, 503, "验证码已发送，请稍后重试"),

    /**
     * 验证码错误或已过期
     */
    VERIFICATION_CODE_ERROR_OR_EXPIRED(ModuleEnum.VERIFICATION_CODE, 504, "验证码错误或已过期"),

    /**
     * 验证码错误
     */
    VERIFICATION_CODE_INVALID(ModuleEnum.VERIFICATION_CODE, 505, "验证码错误"),

    ;


    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 信息描述
     */
    private final String message;

    /**
     * 模块枚举
     */
    private final ModuleEnum moduleEnum;

    ErrorCodeEnum(ModuleEnum moduleEnum, Integer code, String message) {
        this.moduleEnum = moduleEnum;
        this.code = code;
        this.message = message;
    }

    public ModuleEnum getModuleEnum() {
        return moduleEnum;
    }

    public Integer getCode() {
        return code;
    }

    /**
     * 获取业务状态码
     *
     * @return 业务状态码
     */
    public Integer getFullCode() {
        return Integer.valueOf(moduleEnum.getCode() + "" + code);
    }

    public String getMessage() {
        return message;
    }

    /**
     * 判断业务状态码是否代表成功
     * <p>判断后三位是否小于 500</p>
     *
     * @param fullCode 业务状态码
     * @return 是否为成功
     */
    public static boolean isSuccessFor(Integer fullCode) {
        return fullCode % 1000 < 500;
    }
}
