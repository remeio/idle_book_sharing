package com.xumengqi.reme.base.interceptor;

import com.google.gson.Gson;
import com.xumengqi.reme.base.BaseResponse;
import com.xumengqi.reme.base.annotations.AccessToken;
import com.xumengqi.reme.base.conf.SystemConfig;
import com.xumengqi.reme.base.constant.HeaderConstant;
import com.xumengqi.reme.base.util.HttpServletRequestUtils;
import com.xumengqi.reme.base.util.RedisUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import com.xumengqi.reme.common.enums.RedisKeyPrefixEnum;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Token 拦截器，进行用户认证
 * @author xumengqi
 * @date 2021/2/21 10:15
 */
@Order(2)
@Component
public class TokenRequestInterceptor  implements HandlerInterceptor {
    private static final Logger log = Logger.getLogger(TokenRequestInterceptor.class);

    @Autowired
    private RedisUtils<String> redisUtils;

    @Autowired
    private SystemConfig systemConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 不拦截非 controller
        if (!HandlerMethod.class.equals(handler.getClass())) {
            return true;
        }
        // 拦截携带 AccessToken 注解的
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        boolean isHasAnnotationOnClass = handlerMethod.getBeanType().getAnnotation(AccessToken.class) != null;
        boolean isHasAnnotationOnMethod = handlerMethod.getMethod().getAnnotation(AccessToken.class) != null;
        if (!(isHasAnnotationOnClass || isHasAnnotationOnMethod)) {
            // 安全处理
            HttpServletRequestUtils.reflectPutHeader(request, HeaderConstant.AUTHORIZATION, null);
            HttpServletRequestUtils.reflectPutHeader(request, HeaderConstant.OPERATOR_ID, null);
            return true;
        }
        String token = request.getHeader(HeaderConstant.AUTHORIZATION);
        if (StringUtils.isBlank(token)) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.error(ErrorCodeEnum.NO_TOKEN);
            returnJson(response, baseResponse);
            log.info("认证失败：" + ErrorCodeEnum.NO_TOKEN.getMessage());
            return false;
        }
        // 将 token 与缓存中的进行对比
        String key = RedisKeyPrefixEnum.ACCESS_TOKEN.getPrefix() + token;
        String userId = redisUtils.get(key);
        if (userId == null) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.error(ErrorCodeEnum.INVALID_TOKEN);
            returnJson(response, baseResponse);
            log.info("认证失败：" + ErrorCodeEnum.INVALID_TOKEN.getMessage());
            return false;
        }
        // 更新 token 的过期时间
        if (redisUtils.getExpire(key) < TimeUnit.DAYS.toSeconds(systemConfig.getAccessTokenCheckTimeInDay())) {
            redisUtils.expire(key, TimeUnit.DAYS.toSeconds(systemConfig.getAccessTokenExpireTimeInDay()));
        }
        // 将 userId 放到 headers 中
        HttpServletRequestUtils.reflectPutHeader(request, HeaderConstant.OPERATOR_ID, userId);
        return true;
    }

    private void returnJson(HttpServletResponse response, BaseResponse baseResponse) throws Exception {
        Objects.requireNonNull(baseResponse);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        try (PrintWriter writer = response.getWriter()) {
            writer.print(new Gson().toJson(baseResponse));
        }
    }
}
