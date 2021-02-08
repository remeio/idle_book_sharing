package com.xumengqi.reme.as.service;

import com.xumengqi.reme.api.request.LoginRequest;
import com.xumengqi.reme.api.response.LoginResponse;
import com.xumengqi.reme.api.service.UserService;
import com.xumengqi.reme.as.logic.UserLogic;
import com.xumengqi.reme.base.BaseResponse;
import com.xumengqi.reme.base.aspect.LogAspect;
import com.xumengqi.reme.base.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xumengqi
 * @date 2021/2/8 09:18
 */
@LogAspect
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserLogic userLogic;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public LoginResponse login(LoginRequest request) {
        final String username = request.getUsername();
        final String password = request.getPassword();
        userLogic.isValidUser(username, password);
        // 验证通过，添加 jwt
        LoginResponse response = new LoginResponse();
        response.setToken(jwtUtils.generateToken(username));
        return response;
    }
}
