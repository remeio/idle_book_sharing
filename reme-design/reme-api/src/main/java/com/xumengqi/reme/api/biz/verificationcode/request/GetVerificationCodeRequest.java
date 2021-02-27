package com.xumengqi.reme.api.biz.verificationcode.request;

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
    @ApiModelProperty("用户手机号")
    private String userInput;

    @ApiModelProperty("验证码类型编码")
    private String verificationCodeTypeCode;
}
