package com.xumengqi.reme.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 日志界面
 * @author xumengqi
 * @date 2021/1/3 19:14
 */
@Aspect
@Component
public class LogAspectHandler {

    private static final Logger log = Logger.getLogger(LogAspectHandler.class);

    @Pointcut("@annotation(com.xumengqi.reme.aspect.LogAspect)")
    public void logAspectMethod() {

    }

    @Pointcut("@within(com.xumengqi.reme.aspect.LogAspect)")
    public void logAspectType() {

    }

    @Around("logAspectType() || logAspectMethod()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] objects = joinPoint.getArgs();
        log.info("Request->: " + Optional.ofNullable(objects[0]).map(Object::toString).orElse("no args"));
        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            log.info("Throw by \"" + throwable.getMessage() + "\"");
            throw throwable;
        }
        log.info("Response<-: " + result.toString());
        return result;
    }
}
