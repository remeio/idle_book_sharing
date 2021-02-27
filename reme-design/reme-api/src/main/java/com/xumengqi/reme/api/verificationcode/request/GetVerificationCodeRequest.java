package com.xumengqi.reme.api.verificationcode.request;

import com.xumengqi.reme.base.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author xumengqi
 * @date 2021/2/27 14:12
 */
@Getter
@Setter
public class GetVerificationCodeRequest extends BaseRequest {
    @ApiModelProperty("接收方")
    @NotBlank(message = "接收方不能为空")
    private String userParameter;

    @ApiModelProperty("验证码类型")
    @NotBlank(message = "验证码类型不能为空")
    private String verificationCodeTypeName;
}
