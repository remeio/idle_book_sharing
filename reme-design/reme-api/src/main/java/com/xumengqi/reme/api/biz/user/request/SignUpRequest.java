package com.xumengqi.reme.api.biz.user.request;

import com.xumengqi.reme.base.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xumengqi
 * @date 2021/2/27 12:00
 */
@Getter
@Setter
public class SignUpRequest extends BaseRequest {
    @ApiModelProperty("学校ID")
    private Long schoolId;

    @ApiModelProperty("用户手机号")
    private String userPhone;

    @ApiModelProperty("用户密码")
    private String userPassword;

    @ApiModelProperty("验证码")
    private String verificationCode;
}
