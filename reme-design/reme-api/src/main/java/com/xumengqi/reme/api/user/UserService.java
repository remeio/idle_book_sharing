package com.xumengqi.reme.api.user;

import com.xumengqi.reme.api.user.request.SignInRequest;
import com.xumengqi.reme.api.user.response.SignInResponse;
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
     * @param request /
     * @return /
     */
    @ApiOperation("用户登录")
    @PostMapping("/signIn")
    SignInResponse signIn(@ApiParam @Valid @RequestBody SignInRequest request);
}
