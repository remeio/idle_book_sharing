package com.xumengqi.reme.api.request;

import com.xumengqi.reme.base.BaseRequest;

import javax.validation.constraints.NotBlank;

/**
 * @author xumengqi
 * @date 2021/2/8 09:05
 */
public class LoginRequest extends BaseRequest {
    @NotBlank(message = "{LoginRequest.username.NotBlank}")
    private String username;

    @NotBlank(message = "{LoginRequest.password.NotBlank}")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
