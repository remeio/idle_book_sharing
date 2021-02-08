package com.xumengqi.reme.base.aspect;

import java.lang.annotation.*;

/**
 * @author xumengqi
 * @date 2021/2/8 11:17
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
public @interface TokenAspect {
}
