package com.xumengqi.reme.api.request;

import com.xumengqi.reme.base.BaseRequest;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author xumengqi
 * @date 2021/2/8 09:05
 */
@Getter
@Setter
public class LoginRequest extends BaseRequest {
    @NotBlank(message = "{LoginRequest.username.NotBlank}")
    private String username;

    @NotBlank(message = "{LoginRequest.password.NotBlank}")
    private String password;
}
