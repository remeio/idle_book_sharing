package com.xumengqi.reme.common.enums;

/**
 * @author xumengqi
 * @date 2021/2/27 13:34
 */
public enum ModuleEnum {
    /**
     * 系统
     */
    SYSTEM(100),
    /**
     * 用户
     */
    USER(101),
    /**
     * 学校
     */
    SCHOOL(102),
    /**
     * 验证码
     */
    VERIFICATION_CODE(103),

    /**
     * 文件
     */
    FILE(104),

    /**
     * 附件
     */
    ATTACH(105),

    /**
     * 表白
     */
    CONFESSION(106),

    ;
    /**
     * 模块编码
     */
    private final Integer code;

    ModuleEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
