package com.xumengqi.reme.validation.validator;

import com.xumengqi.reme.validation.ChineseLength;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 中文校验器
 *
 * @author xumengqi
 * @date 2021/1/3 12:07
 */
public class ChineseLengthValidator implements ConstraintValidator<ChineseLength, String> {

    private int min;

    private int max;

    @Override
    public void initialize(ChineseLength constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        String bValue = value.replaceAll("[^\\x00-\\xff]", "***");
        final int length = bValue.length();
        return length >= min && length <= max;
    }

}
