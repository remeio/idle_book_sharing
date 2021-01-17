package com.xumengqi.reme.base.aspect;

import java.lang.annotation.*;

/**
 * 日志切面注解
 * @author xumengqi
 * @date 2021/1/3 19:11
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
public @interface LogAspect {

}
