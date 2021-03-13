package com.xumengqi.reme.api.user.response;

import com.xumengqi.reme.base.BaseResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xumengqi
 * @date 2021/2/27 12:01
 */
@Getter
@Setter
public class SignInResponse extends BaseResponse {

    @ApiModelProperty("token")
    private String token;

    @ApiModelProperty("用户ID")
    private Long userId;
}
