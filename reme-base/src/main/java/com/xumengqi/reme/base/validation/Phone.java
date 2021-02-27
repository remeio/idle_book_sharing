package com.xumengqi.reme.base.validation;

import com.xumengqi.reme.base.validation.validator.ChineseLengthValidator;
import com.xumengqi.reme.base.validation.validator.PhoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 手机号码验证
 * @author xumengqi
 * @date 2021/1/3 11:31
 */
@Documented
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = { PhoneValidator.class })
public @interface Phone {
    String message() default "不是合法的手机号码";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
