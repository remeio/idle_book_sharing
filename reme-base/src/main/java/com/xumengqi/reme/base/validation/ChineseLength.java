package com.xumengqi.reme.base.validation;

import com.xumengqi.reme.base.validation.validator.ChineseLengthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 中文长度
 * @author xumengqi
 * @date 2021/1/3 11:31
 */
@Documented
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = { ChineseLengthValidator.class })
public @interface ChineseLength {
    int min() default 0;

    int max() default 2147483647;

    String message() default "长度不在有效范围内";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
