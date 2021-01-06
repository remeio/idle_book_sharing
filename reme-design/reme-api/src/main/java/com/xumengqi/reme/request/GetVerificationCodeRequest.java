package com.xumengqi.reme.request;

import com.xumengqi.reme.base.BaseRequest;

import javax.validation.constraints.Email;

/**
 * @author xumengqi
 * @date 2020/12/29 18:22
 */
public class GetVerificationCodeRequest extends BaseRequest {

    @Email(message = "{GetVerificationCodeRequest.email}")
    private String email;

    public @Email(message = "{GetVerificationCodeRequest.email}") String getEmail() {
        return this.email;
    }

    public void setEmail(@Email(message = "{GetVerificationCodeRequest.email}") String email) {
        this.email = email;
    }
}
