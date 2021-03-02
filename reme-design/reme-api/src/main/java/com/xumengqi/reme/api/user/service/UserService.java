package com.xumengqi.reme.api.user.service;

import com.xumengqi.reme.api.user.request.ResetPasswordRequest;
import com.xumengqi.reme.api.user.request.SignInRequest;
import com.xumengqi.reme.api.user.request.SignUpRequest;
import com.xumengqi.reme.api.user.response.ResetPasswordResponse;
import com.xumengqi.reme.api.user.response.SignInResponse;
import com.xumengqi.reme.api.user.response.SignUpResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 用户服务
 * @author xumengqi
 * @date 2021/2/27 12:00
 */
@Api(tags = "UserService", description = "用户服务")
@RequestMapping("/user")
@RestController
public interface UserService {
    /**
     * 注册用户
     * @param request /
     * @return /
     */
    @ApiOperation("注册用户")
    @PostMapping("/signUp")
    SignUpResponse signUp(@ApiParam @Valid @RequestBody SignUpRequest request);

    /**
     * 用户登录
     * @param request /
     * @return /
     */
    @ApiOperation("用户登录")
    @PostMapping("/signIn")
    SignInResponse signIn(@ApiParam @Valid @RequestBody SignInRequest request);


    /**
     * 重置用户密码，忘记密码时使用
     * @param request /
     * @return /
     */
    @ApiOperation("重置用户密码")
    @PostMapping("/resetPassword")
    ResetPasswordResponse resetPassword(@ApiParam @Valid @RequestBody ResetPasswordRequest request);
}
