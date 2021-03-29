package com.xumengqi.reme.api.user.request;

import com.xumengqi.reme.base.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author xumengqi
 * @date 2021/3/29 20:45
 */
@Getter
@Setter
public class ResetPasswordRequest extends BaseRequest {
    @ApiModelProperty("当前密码")
    @NotBlank
    private String userPassword;

    @ApiModelProperty("新密码")
    @NotBlank
    private String userNewPassword;
}
