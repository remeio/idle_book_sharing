package com.xumengqi.reme.common.enums;

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

    /**
     * 不是有效的是或否
     */
    NOT_YES_OR_NO(ModuleEnum.SYSTEM, 505, "不是有效的是或否"),

    // USER
    /**
     * 手机号或密码错误
     */
    WRONG_PASSWORD(ModuleEnum.USER, 500, "手机号或密码错误"),

    /**
     * 该手机号已被注册
     */
    THE_PHONE_NUMBER_HAS_BEEN_REGISTERED(ModuleEnum.USER, 501, "该手机号已被注册"),

    // SCHOOL
    /**
     * 学校不存在
     */
    SCHOOL_NOT_EXIST(ModuleEnum.SCHOOL, 500, "学校不存在"),

    // FILE
    /**
     * 学校不存在
     */
    FILE_UPLOAD_FAIL(ModuleEnum.FILE, 500, "文件上传失败"),
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
