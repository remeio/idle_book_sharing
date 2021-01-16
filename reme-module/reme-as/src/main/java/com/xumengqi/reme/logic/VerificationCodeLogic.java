package com.xumengqi.reme.logic;

/**
 * @author xumengqi
 * @date 2020/12/30 19:30
 */
public interface VerificationCodeLogic {
    /**
     * 生成验证码
     * @param email 邮箱
     */
    void generateVerificationCode(String email);

    /**
     * 校验验证码是否正确
     * @param email 邮箱
     * @param verificationCode 验证码
     * @return 是否正确
     */
    boolean checkVerificationCode(String email, String verificationCode);

}
