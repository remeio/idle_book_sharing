package com.xumengqi.reme.as.service.biz.user;

import com.xumengqi.reme.api.biz.user.request.ResetPasswordRequest;
import com.xumengqi.reme.api.biz.user.request.SignInRequest;
import com.xumengqi.reme.api.biz.user.request.SignUpRequest;
import com.xumengqi.reme.api.biz.user.response.ResetPasswordResponse;
import com.xumengqi.reme.api.biz.user.response.SignInResponse;
import com.xumengqi.reme.api.biz.user.response.SignUpResponse;
import com.xumengqi.reme.api.biz.user.service.UserService;
import com.xumengqi.reme.as.logic.user.UserLogic;
import com.xumengqi.reme.base.annotations.ParamLog;
import com.xumengqi.reme.base.util.ConvertUtils;
import com.xumengqi.reme.base.util.JwtUtils;
import com.xumengqi.reme.base.util.RedisUtils;
import com.xumengqi.reme.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author xumengqi
 * @date 2021/2/27 13:08
 */
@ParamLog
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserLogic userLogic;

    @Autowired
    private RedisUtils<String> redisUtils;

    @Override
    public SignUpResponse signUp(SignUpRequest request) {
        User user = ConvertUtils.toObj(request, User.class);
        userLogic.addUser(user, request.getVerificationCode());
        return new SignUpResponse();
    }

    @Override
    public SignInResponse signIn(SignInRequest request) {
        Long userId = userLogic.validateUser(request.getUserPhone(), request.getUserPassword());
        String token = UUID.randomUUID().toString();
        redisUtils.set("loginToken:" + token, String.valueOf(userId), TimeUnit.DAYS.toSeconds(7));
        SignInResponse signInResponse = new SignInResponse();
        signInResponse.setToken(token);
        return signInResponse;
    }

    @Override
    public ResetPasswordResponse resetPassword(ResetPasswordRequest request) {
        return null;
    }
}
