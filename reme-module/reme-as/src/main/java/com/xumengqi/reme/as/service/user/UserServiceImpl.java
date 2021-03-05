package com.xumengqi.reme.as.service.user;

import com.xumengqi.reme.api.user.request.ResetPasswordRequest;
import com.xumengqi.reme.api.user.request.SignInRequest;
import com.xumengqi.reme.api.user.request.SignUpRequest;
import com.xumengqi.reme.api.user.response.ResetPasswordResponse;
import com.xumengqi.reme.api.user.response.SignInResponse;
import com.xumengqi.reme.api.user.response.SignUpResponse;
import com.xumengqi.reme.api.user.service.UserService;
import com.xumengqi.reme.as.logic.user.UserLogic;
import com.xumengqi.reme.base.annotations.SystemLog;
import com.xumengqi.reme.base.conf.SystemConfig;
import com.xumengqi.reme.base.util.AssertUtils;
import com.xumengqi.reme.base.util.ConvertUtils;
import com.xumengqi.reme.base.util.RedisUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import com.xumengqi.reme.common.enums.RedisKeyPrefixEnum;
import com.xumengqi.reme.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author xumengqi
 * @date 2021/2/27 13:08
 */
@SystemLog
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserLogic userLogic;

    @Autowired
    private RedisUtils<String> redisUtils;

    @Autowired
    private SystemConfig systemConfig;

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
        // 将 token 存入到缓存中
        redisUtils.set(RedisKeyPrefixEnum.ACCESS_TOKEN.getPrefix() + token,
                String.valueOf(userId),
                TimeUnit.DAYS.toSeconds(systemConfig.getAccessTokenExpireTimeInDay()));
        SignInResponse signInResponse = new SignInResponse();
        signInResponse.setToken(token);
        return signInResponse;
    }

    @Override
    public ResetPasswordResponse resetPassword(ResetPasswordRequest request) {
        final String userPhone = request.getUserPhone();
        final String verificationCode = request.getVerificationCode();
        // 验证验证码是否正确
        String resetPasswordVerificationCodeInCache = redisUtils.get(RedisKeyPrefixEnum.RESET_PASSWORD_VERIFICATION_CODE.getPrefix() + userPhone);
        AssertUtils.isTrue(verificationCode.equals(resetPasswordVerificationCodeInCache), ErrorCodeEnum.VERIFICATION_CODE_INVALID);
        // 修改密码
        userLogic.resetPassword(userPhone, request.getNewPassword());
        return new ResetPasswordResponse();
    }
}
