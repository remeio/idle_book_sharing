package com.xumengqi.reme.base.interceptor;

import com.google.gson.Gson;
import com.xumengqi.reme.base.BaseResponse;
import com.xumengqi.reme.base.annotations.AccessToken;
import com.xumengqi.reme.base.util.JwtUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
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

/**
 * @author xumengqi
 * @date 2021/2/21 10:15
 */
@Order(2)
@Component
public class TokenRequestInterceptor  implements HandlerInterceptor {
    private static final Logger log = Logger.getLogger(TokenRequestInterceptor.class);

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 不拦截非 controller
        if (!HandlerMethod.class.equals(handler.getClass())) {
            return true;
        }
        // 拦截携带 TokenAspect 注解的
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        boolean isHasAnnotationOnClass = handlerMethod.getBeanType().getAnnotation(AccessToken.class) != null;
        boolean isHasAnnotationOnMethod = handlerMethod.getMethod().getAnnotation(AccessToken.class) != null;
        if (!(isHasAnnotationOnClass || isHasAnnotationOnMethod)) {
            return true;
        }
        String token = request.getHeader("Authorization");
        if (StringUtils.isBlank(token)) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.error(ErrorCodeEnum.NO_TOKEN);
            returnJson(response, baseResponse);
            log.info("认证失败：" + ErrorCodeEnum.NO_TOKEN.getMessage());
            return false;
        }
        if (!jwtUtils.validateToken(token)) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.error(ErrorCodeEnum.INVALID_TOKEN);
            returnJson(response, baseResponse);
            log.info("认证失败：" + ErrorCodeEnum.INVALID_TOKEN.getMessage());
            return false;
        }
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