package com.xumengqi.reme.as.logic.verificationcode;

import com.xumengqi.reme.as.enums.VerificationCodeTypeEnum;

/**
 * @author xumengqi
 * @date 2021/2/27 14:28
 */
public interface VerificationCodeLogic {

    /**
     * 生成并发送验证码
     * @param to 接收方
     * @param verificationCodeTypeEnum 验证码类型
     */
    void generateAndSendVerificationCode(String to, VerificationCodeTypeEnum verificationCodeTypeEnum);
}
