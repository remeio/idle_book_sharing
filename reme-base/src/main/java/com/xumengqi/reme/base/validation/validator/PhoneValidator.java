package com.xumengqi.reme.base.validation.validator;

import com.xumengqi.reme.base.validation.ChineseLength;
import com.xumengqi.reme.base.validation.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 手机号码校验器
 *
 * @author xumengqi
 * @date 2021/1/3 12:07
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return value.matches("/^1(3[0-9]|4[01456879]|5[0-35-9]|6[2567]|7[0-8]|8[0-9]|9[0-35-9])\\d{8}$/");
    }

}
