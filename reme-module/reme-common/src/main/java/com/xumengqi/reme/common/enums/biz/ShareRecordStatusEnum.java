package com.xumengqi.reme.common.enums.biz;

import java.util.Arrays;

/**
 * @author xumengqi
 * @date 2021/3/26 19:07
 */
public enum ShareRecordStatusEnum {
    /**
     * 已下单
     */
    ORDER_HAS_BEEN_PLACED(1, "已下单"),
    /**
     * 借阅中
     */
    BORROWING(2, "借阅中"),
    /**
     * 已归还
     */
    RETURNED(3, "已归还"),
    /**
     * 逾期归还
     */
    OVERDUE_RETURNED(4, "逾期归还"),
    /**
     * 下单后取消
     */
    CANCEL_AFTER_ORDER(5, "下单后取消"),
    /**
     * 书籍丢失或严重受损
     */
    LOST_OR_DAMAGED(6, "书籍丢失或严重受损"),
    /**
     * 书籍逾期严重不归还
     */
    SERIOUSLY_OVERDUE(7, "书籍逾期严重不归还");

    private final Integer code;

    private final String description;

    ShareRecordStatusEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static ShareRecordStatusEnum getByCode(Integer code) {
        return Arrays.stream(values()).filter(e -> e.getCode().equals(code)).findFirst().orElse(null);
    }
}
