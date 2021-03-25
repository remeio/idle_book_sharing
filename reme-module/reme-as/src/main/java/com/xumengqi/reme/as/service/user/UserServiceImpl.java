package com.xumengqi.reme.as.service.user;

import com.xumengqi.reme.api.user.UserService;
import com.xumengqi.reme.api.user.request.GetSchoolInfoRequest;
import com.xumengqi.reme.api.user.request.SignInRequest;
import com.xumengqi.reme.api.user.request.SignUpRequest;
import com.xumengqi.reme.api.user.response.GetSchoolInfoResponse;
import com.xumengqi.reme.api.user.response.SignInResponse;
import com.xumengqi.reme.api.user.response.SignUpResponse;
import com.xumengqi.reme.as.logic.user.UserLogic;
import com.xumengqi.reme.base.annotations.AccessToken;
import com.xumengqi.reme.base.annotations.SystemLog;
import com.xumengqi.reme.base.conf.SystemConfig;
import com.xumengqi.reme.base.util.RedisUtils;
import com.xumengqi.reme.common.enums.RedisKeyPrefixEnum;
import com.xumengqi.reme.dao.entity.School;
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
    public SignInResponse signIn(SignInRequest request) {
        Long userId = userLogic.validateUser(request.getUserPhone(), request.getUserPassword());
        String token = UUID.randomUUID().toString();
        // 将 token 存入到缓存中
        redisUtils.set(RedisKeyPrefixEnum.ACCESS_TOKEN.getPrefix() + token,
                String.valueOf(userId),
                TimeUnit.DAYS.toSeconds(systemConfig.getAccessTokenExpireTimeInDay()));
        SignInResponse signInResponse = new SignInResponse();
        signInResponse.setToken(token);
        signInResponse.setUserId(userId);
        return signInResponse;
    }

    @Override
    public SignUpResponse signUp(SignUpRequest request) {
        User user = new User();
        user.setUserPhone(request.getUserPhone());
        user.setUserPassword(request.getUserPassword());
        user.setUserFullName(request.getUserFullName());
        userLogic.addUser(user, request.getSchoolName());
        return new SignUpResponse();
    }

    @AccessToken
    @Override
    public GetSchoolInfoResponse getSchoolInfo(GetSchoolInfoRequest request) {
        School school = userLogic.getSchoolByUserId(request.getOperatorId());
        GetSchoolInfoResponse response = new GetSchoolInfoResponse();
        response.setSchoolId(school.getId());
        response.setSchoolName(school.getSchoolName());
        return response;
    }
}
