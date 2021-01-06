package com.xumengqi.reme.request;

import com.xumengqi.reme.base.BaseRequest;
import com.xumengqi.reme.validation.ChineseLength;

import javax.validation.constraints.Email;

/**
 * @author xumengqi
 * @date 2020/12/29 19:43
 */
public class CheckVerificationCodeRequest extends BaseRequest {
    @Email(message = "{CheckVerificationCodeRequest.email}")
    private String email;

    @ChineseLength(min = 6, max = 6, message = "{CheckVerificationCodeRequest.verificationCode}")
    private String verificationCode;

    public @Email(message = "{CheckVerificationCodeRequest.email}") String getEmail() {
        return this.email;
    }

    public @ChineseLength(min = 6, max = 6, message = "{CheckVerificationCodeRequest.verificationCode}") String getVerificationCode() {
        return this.verificationCode;
    }

    public void setEmail(@Email(message = "{CheckVerificationCodeRequest.email}") String email) {
        this.email = email;
    }

    public void setVerificationCode(@ChineseLength(min = 6, max = 6, message = "{CheckVerificationCodeRequest.verificationCode}") String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
