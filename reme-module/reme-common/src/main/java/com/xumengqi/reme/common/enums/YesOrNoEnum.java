package com.xumengqi.reme.common.enums;

import java.util.Arrays;

/**
 * @author xumengqi
 * @date 2021/3/9 11:29
 */
public enum YesOrNoEnum {
    /**
     * 是
     */
    YES(1, "是"),
    /**
     * 否
     */
    NO(2, "否"),
    ;
    private final Integer code;

    private final String description;

    YesOrNoEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static boolean isYes(Integer code) {
        return YES.getCode().equals(code);
    }

    public static boolean isNo(Integer code) {
        return NO.getCode().equals(code);
    }

    public static YesOrNoEnum getByCode(Integer code) {
        return Arrays.stream(values()).filter(e -> e.getCode().equals(code)).findFirst().orElse(null);
    }
}
