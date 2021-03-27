package com.xumengqi.reme.common.enums.biz;

import java.util.Arrays;

/**
 * @author xumengqi
 * @date 2021/3/9 11:29
 */
public enum BookStatusEnum {
    /**
     * 空闲
     */
    IDLE(1, "空闲"),
    /**
     * 受理中
     */
    ACCEPTING(2, "受理中"),

    /**
     * 异常
     */
    ABNORMAL(3, "异常"),

    /**
     * 已下架
     */
    HAD_OFF_SHELF(4, "已下架"),

    /**
     * 已删除
     */
    HAD_DELETED(5, "已删除");

    private final Integer code;

    private final String description;

    BookStatusEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static BookStatusEnum getByCode(Integer code) {
        return Arrays.stream(values()).filter(e -> e.getCode().equals(code)).findFirst().orElse(null);
    }
}
