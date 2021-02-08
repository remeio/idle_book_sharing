package com.xumengqi.reme.api.service;

import com.xumengqi.reme.api.request.LoginRequest;
import com.xumengqi.reme.api.response.LoginResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author xumengqi
 * @date 2021/2/8 09:14
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
    @PostMapping("/login")
    LoginResponse login(@Valid @RequestBody @ApiParam LoginRequest request);
}
