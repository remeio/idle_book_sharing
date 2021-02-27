package com.xumengqi.reme.api.verificationcode.request;

import com.xumengqi.reme.base.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xumengqi
 * @date 2021/2/27 14:12
 */
@Getter
@Setter
public class GetVerificationCodeRequest extends BaseRequest {
    @ApiModelProperty("用户参数")
    private String userParameter;

    @ApiModelProperty("验证码类型")
    private String verificationCodeTypeName;
}
