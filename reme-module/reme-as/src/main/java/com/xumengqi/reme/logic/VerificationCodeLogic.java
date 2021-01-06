package com.xumengqi.reme.logic;

/**
 * @author xumengqi
 * @date 2020/12/30 19:30
 */
public interface VerificationCodeLogic {
    String generateVerificationCode(String email);

    boolean checkVerificationCode(String email, String verificationCode);

}
