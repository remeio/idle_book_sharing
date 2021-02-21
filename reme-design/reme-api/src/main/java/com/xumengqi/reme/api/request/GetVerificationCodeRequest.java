package com.xumengqi.reme.api.request;

import com.xumengqi.reme.base.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author xumengqi
 * @date 2020/12/29 18:22
 */
@Getter
@Setter
public class GetVerificationCodeRequest extends BaseRequest {

    @ApiModelProperty("邮箱")
    @NotBlank(message = "{GetVerificationCodeRequest.email}")
    @Email(message = "{GetVerificationCodeRequest.email}")
    private String email;

}
