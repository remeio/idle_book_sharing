package com.xumengqi.reme.api.user.request;

import com.xumengqi.reme.base.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xumengqi
 * @date 2021/2/27 12:01
 */
@Getter
@Setter
public class SignInRequest extends BaseRequest {
    @ApiModelProperty("用户手机号")
    private String userPhone;

    @ApiModelProperty("用户密码")
    private String userPassword;

}
