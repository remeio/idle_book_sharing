package com.xumengqi.reme.logic.impl;

import com.xumengqi.reme.conf.VerificationCodeConfig;
import com.xumengqi.reme.enums.ErrorCodeEnum;
import com.xumengqi.reme.exception.BizException;
import com.xumengqi.reme.logic.VerificationCodeLogic;
import com.xumengqi.reme.util.RedisUtils;
import com.xumengqi.reme.util.SendMailUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xumengqi
 * @date 2020/12/30 19:30
 */
@Component
public class VerificationCodeLogicImpl implements VerificationCodeLogic {
    private VerificationCodeConfig verificationCodeConfig;

    private RedisUtils<String> redisUtils;

    private SendMailUtils mailUtils;

    @Autowired
    private void setRedisUtils(RedisUtils<String> redisUtils) {
        this.redisUtils = redisUtils;
    }

    @Autowired
    private void setVerificationCodeConfig(VerificationCodeConfig verificationCodeConfig) {
        this.verificationCodeConfig = verificationCodeConfig;
    }

    @Autowired
    private void setMailUtils(SendMailUtils mailUtils) {
        this.mailUtils = mailUtils;
    }

    @Override
    public void generateVerificationCode(String email) {
        String verificationCodeKey = verificationCodeConfig.getPrefix() + email;
        boolean isHasKey = redisUtils.hasKey(verificationCodeKey);
        //判断是否已经发送
        if (isHasKey) {
            BizException.error(ErrorCodeEnum.VERIFICATION_CODE_HAD_SENT);
        }
        // 生成验证码
        String verificationCodeValue = RandomStringUtils.random(verificationCodeConfig.getDigits(), false, true);
        try {
            mailUtils.sendSimpleMail(email,
                    verificationCodeConfig.getMailSubject(),
                    String.format(verificationCodeConfig.getMailContent(),
                            verificationCodeValue,
                            verificationCodeConfig.getExpireTime()));
        } catch (Exception e) {
            BizException.error(ErrorCodeEnum.VERIFICATION_CODE_SEND_FAILURE);
        }
        redisUtils.set(verificationCodeKey, verificationCodeValue, verificationCodeConfig.getExpireTime() * 60);
    }

    @Override
    public boolean checkVerificationCode(String email, String verificationCode) {
        String verificationCodeKey = verificationCodeConfig.getPrefix() + email;
        if (!redisUtils.hasKey(verificationCodeKey)) {
            BizException.error(ErrorCodeEnum.VERIFICATION_CODE_HAD_EXPIRED);
        }
        return verificationCode.equals(redisUtils.get(verificationCodeKey));
    }

}
