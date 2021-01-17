package com.xumengqi.reme.api.request;

import com.xumengqi.reme.base.BaseRequest;
import com.xumengqi.reme.base.validation.ChineseLength;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;

/**
 * @author xumengqi
 * @date 2020/12/29 19:43
 */
public class CheckVerificationCodeRequest extends BaseRequest {
    @ApiModelProperty("邮箱")
    @Email(message = "{CheckVerificationCodeRequest.email}")
    private String email;

    @ApiModelProperty("验证码")
    @ChineseLength(min = 6, max = 6, message = "{CheckVerificationCodeRequest.verificationCode}")
    private String verificationCode;

    public String getEmail() {
        return this.email;
    }

    public String getVerificationCode() {
        return this.verificationCode;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
