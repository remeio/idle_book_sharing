package com.xumengqi.reme.common.enums.biz;

import java.util.Arrays;

/**
 * @author xumengqi
 * @date 2021/3/26 19:16
 */
public enum OperatorTypeEnum {
    /**
     * 共享者
     */
    SHARER(1, "共享者"),

    /**
     * 借阅者
     */
    BORROWER(2, "借阅者");

    private final Integer code;

    private final String description;

    OperatorTypeEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static OperatorTypeEnum getByCode(Integer code) {
        return Arrays.stream(values()).filter(e -> e.getCode().equals(code)).findFirst().orElse(null);
    }
}
