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
