package com.xumengqi.reme.common.enums.biz;

import java.util.Arrays;

/**
 * @author xumengqi
 * @date 2021/3/26 19:18
 */
public enum DepositOperateTypeEnum {
    /**
     * 缴纳
     */
    PAY(1, "缴纳"),
    /**
     * 提取
     */
    DRAW(2, "提取"),

    /**
     * 占用押金
     */
    OCCUPY(3, "占用押金"),

    /**
     * 释放押金
     */
    RELEASE(4, "释放押金"),

    /**
     * 支付损失
     */
    PAY_LOSS(5, "支付损失"),

    /**
     * 所得补偿
     */
    COMPENSATION(6, "所得补偿"),

    ;
    private final Integer code;

    private final String description;

    DepositOperateTypeEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static DepositOperateTypeEnum getByCode(Integer code) {
        return Arrays.stream(values()).filter(e -> e.getCode().equals(code)).findFirst().orElse(null);
    }
}
