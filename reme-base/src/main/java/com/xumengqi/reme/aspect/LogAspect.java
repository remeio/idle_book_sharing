package com.xumengqi.reme.aspect;

import java.lang.annotation.*;

/**
 * @author xumengqi
 * @date 2021/1/3 19:11
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
public @interface LogAspect {

}
