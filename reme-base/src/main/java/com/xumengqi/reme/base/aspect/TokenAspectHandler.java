package com.xumengqi.reme.base.aspect;

import com.xumengqi.reme.base.BaseRequest;
import com.xumengqi.reme.base.BizException;
import com.xumengqi.reme.base.util.AssertUtils;
import com.xumengqi.reme.base.util.JwtUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author xumengqi
 * @date 2021/2/8 11:18
 */
@Order(1)
@Aspect
@Component
public class TokenAspectHandler {

    @Autowired
    private JwtUtils jwtUtils;

    @Pointcut("@annotation(com.xumengqi.reme.base.aspect.TokenAspect)")
    public void aspectMethod() {

    }

    @Pointcut("@within(com.xumengqi.reme.base.aspect.TokenAspect)")
    public void aspectType() {

    }

    @Before("aspectMethod() || aspectType()")
    public void tokenBefore(JoinPoint joinPoint) {
        BaseRequest request = (BaseRequest) Arrays.stream(joinPoint.getArgs()).findFirst().orElse(null);
        if (request != null) {
            String token = request.getToken();
            AssertUtils.isTrue(StringUtils.isNotBlank(token), ErrorCodeEnum.NO_TOKEN);
            AssertUtils.isTrue(jwtUtils.validateToken(token), ErrorCodeEnum.INVALID_TOKEN);
            request.setOperator(jwtUtils.getClaimsFromToken(token).getSubject());
        }
    }
}
