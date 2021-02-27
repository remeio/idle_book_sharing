package com.xumengqi.reme.api.biz.verificationcode.response;

import com.xumengqi.reme.base.BaseResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xumengqi
 * @date 2021/2/27 14:12
 */
@Getter
@Setter
public class GetVerificationCodeResponse extends BaseResponse {
    @ApiModelProperty("验证码")
    String verificationCode;
}
