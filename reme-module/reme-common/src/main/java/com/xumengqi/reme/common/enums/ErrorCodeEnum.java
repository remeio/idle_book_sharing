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

    /**
     * 没有权限
     */
    PERMISSION_DENIED(ModuleEnum.SYSTEM, 506, "没有权限"),

    // USER
    /**
     * 手机号或密码错误
     */
    WRONG_PASSWORD(ModuleEnum.USER, 500, "手机号或密码错误"),

    /**
     * 该手机号已被注册
     */
    THE_PHONE_NUMBER_HAS_BEEN_REGISTERED(ModuleEnum.USER, 501, "该手机号已被注册"),

    /**
     * 用户不存在
     */
    USER_NOT_EXIST(ModuleEnum.USER, 502, "用户不存在"),


    /**
     * 当前密码错误
     */
    THE_CURRENT_PASSWORD_IS_WRONG(ModuleEnum.USER, 502, "当前密码错误"),

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

    // BOOK_CATALOG
    /**
     * 书籍分类不存在
     */
    BOOK_CATALOG_NOT_EXIST(ModuleEnum.BOOK_CATALOG, 500, "书籍分类不存在"),

    // BOOK
    /**
     * 书籍不存在
     */
    BOOK_NOT_EXIST(ModuleEnum.BOOK, 500, "书籍不存在"),

    /**
     * 书籍状态不匹配
     */
    BOOK_BORROWING(ModuleEnum.BOOK, 501, "当前书籍不允许借阅"),

    /**
     * 当前书籍不能被下架
     */
    BOOK_CAN_NOT_OFF_SHELF(ModuleEnum.BOOK, 502, "当前书籍不能被下架"),
    /**
     * 当前书籍不能被删除
     */
    BOOK_CAN_NOT_DELETED(ModuleEnum.BOOK, 503, "当前书籍不能被删除"),
    /**
     * 当前书籍不能被上架
     */
    BOOK_CAN_NOT_ON_SHELF(ModuleEnum.BOOK, 504, "当前书籍不能被上架"),


    // SHARE_RECORD

    /**
     * 共享记录不存在
     */
    SHARE_RECORD_NOT_EXIST(ModuleEnum.SHARE_RECORD, 500, "共享记录不存在"),

    /**
     * 共享记录与操作者不匹配
     */
    SHARE_RECORD_NOT_MATCH(ModuleEnum.SHARE_RECORD, 501, "共享记录与操作者不匹配"),

    /**
     * 共享记录修改状态不匹配
     */
    SHARE_RECORD_STATUS_NOT_MATCH(ModuleEnum.SHARE_RECORD, 502, "共享记录修改状态不匹配"),


    /**
     * 书籍共享同时又借阅
     */
    BOOK_BORROW_AND_SHARE_ON_SAME_TIME(ModuleEnum.SHARE_RECORD, 503, "不能借阅自己所共享的书籍"),


    // DEPOSIT
    /**
     * 可用押金不足
     */
    CAN_USE_DEPOSIT_NOT_ENOUGH(ModuleEnum.DEPOSIT, 500, "可用押金不足"),

    /**
     * 占用余额不足
     */
    OCCUPY_DEPOSIT_NOT_ENOUGH(ModuleEnum.DEPOSIT, 501, "占用押金不足"),


    BOOKCASE_NOT_EXIT(ModuleEnum.BOOKCASE, 500, "书箱记录不存在")
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
