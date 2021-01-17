package com.xumengqi.reme.api.request;

import com.xumengqi.reme.base.BaseRequest;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author xumengqi
 * @date 2020/12/29 18:22
 */
public class GetVerificationCodeRequest extends BaseRequest {

    @ApiModelProperty("邮箱")
    @NotBlank(message = "{GetVerificationCodeRequest.email}")
    @Email(message = "{GetVerificationCodeRequest.email}")
    private String email;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
