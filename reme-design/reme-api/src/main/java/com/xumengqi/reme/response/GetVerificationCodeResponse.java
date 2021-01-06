package com.xumengqi.reme.response;

import com.xumengqi.reme.base.BaseResponse;

/**
 * @author xumengqi
 * @date 2020/12/29 18:22
 */
public class GetVerificationCodeResponse extends BaseResponse {
    private String verificationCode;

    public String getVerificationCode() {
        return this.verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
