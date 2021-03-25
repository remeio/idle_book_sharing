package com.xumengqi.reme.common.enums.biz;

import java.util.Arrays;

/**
 * @author xumengqi
 * @date 2021/3/9 11:29
 */
public enum BookStatusEnum {
    /**
     * 可借阅
     */
    CAN_BE_BORROWED(1, "可借阅"),
    /**
     * 已下单
     */
    ORDER_HAS_BEEN_PLACED(2, "已下单"),

    /**
     * 借阅中
     */
    BORROWING(3, "借阅中"),

    /**
     * 已下架
     */
    HAD_DELETED(4, "已下架");
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
