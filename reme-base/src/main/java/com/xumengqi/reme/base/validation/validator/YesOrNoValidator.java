package com.xumengqi.reme.base.validation.validator;

import com.xumengqi.reme.base.validation.YesOrNo;
import com.xumengqi.reme.common.enums.YesOrNoEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 是否校验器
 *
 * @author xumengqi
 * @date 2021/1/3 12:07
 */
public class YesOrNoValidator implements ConstraintValidator<YesOrNo, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return YesOrNoEnum.getByCode(value) != null;
    }

}
