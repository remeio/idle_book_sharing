package com.xumengqi.reme.as.logic.verificationcode;

/**
 * @author xumengqi
 * @date 2021/2/27 14:28
 */
public interface VerificationCodeLogic {

    /**
     * 生成并发送验证码
     * @param to 接收方
     * @param verificationCodeTypeName 验证码类型
     */
    void generateAndSendVerificationCode(String to, String verificationCodeTypeName);
}
