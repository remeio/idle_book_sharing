package com.xumengqi.reme.base.aspect;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 日志切面
 * @author xumengqi
 * @date 2021/1/3 19:14
 */
@Aspect
@Component
public class LogAspectHandler {

    private static final Logger log = Logger.getLogger(LogAspectHandler.class);

    @Pointcut("@annotation(com.xumengqi.reme.base.aspect.LogAspect)")
    public void logAspectMethod() {

    }

    @Pointcut("@within(com.xumengqi.reme.base.aspect.LogAspect)")
    public void logAspectType() {

    }

    @Around("logAspectType() || logAspectMethod()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] objects = joinPoint.getArgs();
        log.debug((Optional.ofNullable(objects[0]).map(Object::getClass).map(Class::getName).orElse("Request") + "->: \n" + toJsonPretty(Optional.ofNullable(objects[0]).map(Object::toString).orElse("no args"))));
        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            log.debug("Throw by \"" + throwable.getMessage() + "\"");
            throw throwable;
        }
        log.debug(result.getClass().getName() + "<-: \n" + toJsonPretty(result.toString()));
        return result;
    }

    public String toJsonPretty(String jsonString) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return gson.toJson(JsonParser.parseString(jsonString));
        } catch (Exception e) {
            return jsonString;
        }
    }
}
