package com.xumengqi.reme.common.enums;

/**
 * @author xumengqi
 * @date 2021/2/27 13:34
 */
public enum ModuleEnum {
    SYSTEM(100),
    USER(101)
    ;
    /**
     * 状态码
     */
    private final Integer code;

    ModuleEnum(Integer code) {
        this.code = code;
    }
    public Integer getCode() {
        return code;
    }
}
