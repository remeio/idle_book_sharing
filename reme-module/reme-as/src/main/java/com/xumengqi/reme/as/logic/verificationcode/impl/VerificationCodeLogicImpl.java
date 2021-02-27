package com.xumengqi.reme.as.logic.verificationcode.impl;

import com.xumengqi.reme.as.enums.VerificationCodeTypeEnum;
import com.xumengqi.reme.as.logic.verificationcode.VerificationCodeLogic;
import com.xumengqi.reme.as.logic.verificationcode.handler.GenerateAble;
import com.xumengqi.reme.as.logic.verificationcode.handler.SendAble;
import com.xumengqi.reme.base.BizException;
import com.xumengqi.reme.base.util.ApplicationContextUtils;
import com.xumengqi.reme.base.util.AssertUtils;
import com.xumengqi.reme.base.util.RedisUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xumengqi
 * @date 2021/2/27 14:28
 */
@Component
public class VerificationCodeLogicImpl implements VerificationCodeLogic {

    @Autowired
    private RedisUtils<String> redisUtils;

    @Override
    public void generateAndSendVerificationCode(String to, VerificationCodeTypeEnum verificationCodeTypeEnum) {
        GenerateAble generateAble = ApplicationContextUtils.getBean(verificationCodeTypeEnum.getGenerateAbleClass());
        SendAble sendAble = ApplicationContextUtils.getBean(verificationCodeTypeEnum.getSendAbleClass());
        AssertUtils.isNotNull(generateAble, ErrorCodeEnum.SQL_ERROR);
        AssertUtils.isNotNull(sendAble, ErrorCodeEnum.SQL_ERROR);
        AssertUtils.isNull(redisUtils.get(generateAble.generateKey(to, verificationCodeTypeEnum)), ErrorCodeEnum.NO_TOKEN);
        redisUtils.set(generateAble.generateKey(to, verificationCodeTypeEnum), generateAble.generateVerificationCode());
        try {
            sendAble.send(to, generateAble.generateKey(to, verificationCodeTypeEnum));
        } catch (Exception e) {
            BizException.error(ErrorCodeEnum.SQL_ERROR);
        }
    }
}
