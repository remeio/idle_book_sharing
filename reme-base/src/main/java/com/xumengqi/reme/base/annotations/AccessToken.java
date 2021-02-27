package com.xumengqi.reme.base.annotations;

import java.lang.annotation.*;

/**
 * 访问注解
 * @author xumengqi
 * @date 2021/2/8 11:17
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
public @interface AccessToken {
}
