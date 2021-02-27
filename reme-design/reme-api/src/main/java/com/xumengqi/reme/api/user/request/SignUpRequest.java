package com.xumengqi.reme.api.user.request;

import com.xumengqi.reme.base.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author xumengqi
 * @date 2021/2/27 12:00
 */
@Getter
@Setter
public class SignUpRequest extends BaseRequest {

    @ApiModelProperty("学校ID")
    @NotNull(message = "学校不能为空")
    private Long schoolId;

    @ApiModelProperty("用户手机号")
    @Length(min = 11, max = 11, message = "手机号必须为 11 位")
    private String userPhone;

    @ApiModelProperty("用户密码")
    @Length(min = 1, max = 100, message = "用户密码输入不合法")
    private String userPassword;

    @ApiModelProperty("验证码")
    @Length(min = 4, max = 100, message = "验证码输入不合法")
    private String verificationCode;
}
