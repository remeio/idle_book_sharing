package com.xumengqi.reme.api.request;

import com.xumengqi.reme.base.BaseRequest;
import com.xumengqi.reme.base.validation.ChineseLength;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

/**
 * @author xumengqi
 * @date 2020/12/29 19:43
 */
@Getter
@Setter
public class CheckVerificationCodeRequest extends BaseRequest {
    @ApiModelProperty("邮箱")
    @Email(message = "{CheckVerificationCodeRequest.email}")
    private String email;

    @ApiModelProperty("验证码")
    @ChineseLength(min = 6, max = 6, message = "{CheckVerificationCodeRequest.verificationCode}")
    private String verificationCode;
}
