package com.xumengqi.reme.api.user;

import com.xumengqi.reme.api.user.request.*;
import com.xumengqi.reme.api.user.response.*;
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
     * 用户登录
     *
     * @param request /
     * @return /
     */
    @ApiOperation("用户登录")
    @PostMapping("/signIn")
    SignInResponse signIn(@ApiParam @Valid @RequestBody SignInRequest request);

    /**
     * 注册用户
     *
     * @param request /
     * @return /
     */
    @ApiOperation("注册用户")
    @PostMapping("/signUp")
    SignUpResponse signUp(@ApiParam @Valid @RequestBody SignUpRequest request);

    /**
     * 获取学校信息
     *
     * @param request /
     * @return /
     */
    @ApiOperation("获取学校名称")
    @PostMapping("/getSchoolInfo")
    GetSchoolInfoResponse getSchoolInfo(@ApiParam @Valid @RequestBody GetSchoolInfoRequest request);

    /**
     * 获取用户信息
     *
     * @param request /
     * @return /
     */
    @ApiOperation("获取用户信息")
    @PostMapping("/getUserInfo")
    GetUserInfoResponse getUserInfo(@ApiParam @Valid @RequestBody GetUserInfoRequest request);

    /**
     * 修改用户密码
     *
     * @param request /
     * @return /
     */
    @ApiOperation("修改用户密码")
    @PostMapping("/resetPassword")
    ResetPasswordResponse resetPassword(@ApiParam @Valid @RequestBody ResetPasswordRequest request);
}
