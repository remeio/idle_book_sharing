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
     * 文件
     */
    FILE(103),

    /**
     * 书籍分类
     */
    BOOK_CATALOG(104),
    /**
     * 书籍
     */
    BOOK(105),

    /**
     * 共享记录
     */
    SHARE_RECORD(106),

    /**
     * 共享日志
     */
    SHARE_LOG(107),

    /**
     * 押金
     */
    DEPOSIT(108);
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
