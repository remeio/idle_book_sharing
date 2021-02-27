package com.xumengqi.reme.as.logic.verificationcode.handler;

import com.xumengqi.reme.as.enums.VerificationCodeTypeEnum;

/**
 * @author xumengqi
 * @date 2021/2/27 15:18
 */
public interface GenerateAble {
    /**
     * 生成验证码标识
     * @param to 接收方
     * @param verificationCodeTypeEnum 验证码类型
     * @return 验证码标识
     */
    default String generateKey(String to, VerificationCodeTypeEnum verificationCodeTypeEnum) {
        return verificationCodeTypeEnum.getCode() + ":" + to;
    };

    /**
     * 生成验证码
     * @return 验证码
     */
    String generateVerificationCode();


    /**
     * 生成过期时间
     * @return /
     */
    Long generateExpireTime();
}
