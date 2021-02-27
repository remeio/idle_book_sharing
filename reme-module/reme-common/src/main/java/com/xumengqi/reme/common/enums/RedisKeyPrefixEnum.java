package com.xumengqi.reme.common.enums;

/**
 * redis 键前缀
 * <p>eg. 注册验证码存到缓存中，keyPrefix 为 "suvc:"，key 为 "suvc:17888888888"</p>
 * @author xumengqi
 * @date 2021/2/27 18:47
 */
public enum RedisKeyPrefixEnum {
    /**
     * 注册验证码
     */
    SIGN_UP_VERIFICATION_CODE("suvc", "注册验证码"),
    /**
     * 验证 token
     */
    ACCESS_TOKEN("at", "验证 token")
    ;

    /**
     * 前缀，不能重复
     */
    private final String code;

    /**
     * 描述
     */
    private final String description;

    RedisKeyPrefixEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getPrefix() {
        return getCode() + ":";
    }

    public String getDescription() {
        return description;
    }
}
