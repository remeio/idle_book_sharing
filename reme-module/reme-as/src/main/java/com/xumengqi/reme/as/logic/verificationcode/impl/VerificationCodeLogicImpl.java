package com.xumengqi.reme.as.logic.verificationcode.impl;

import com.xumengqi.reme.as.conf.VerificationCodeConfig;
import com.xumengqi.reme.as.logic.verificationcode.VerificationCodeLogic;
import com.xumengqi.reme.base.BizException;
import com.xumengqi.reme.base.util.AssertUtils;
import com.xumengqi.reme.base.util.RedisUtils;
import com.xumengqi.reme.base.util.SendMailUtils;
import com.xumengqi.reme.common.enums.ErrorCodeEnum;
import com.xumengqi.reme.common.enums.RedisKeyPrefixEnum;
import com.xumengqi.reme.common.enums.biz.VerificationCodeSendModeEnum;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author xumengqi
 * @date 2021/2/27 14:28
 */
@Component
public class VerificationCodeLogicImpl implements VerificationCodeLogic {
    private static final Logger log = Logger.getLogger(VerificationCodeLogicImpl.class);

    @Autowired
    private RedisUtils<String> redisUtils;

    @Autowired
    private SendMailUtils sendMailUtils;

    @Autowired
    private VerificationCodeConfig verificationCodeConfig;

    @Override
    public void generateAndSendVerificationCode(String to, String verificationCodeTypeName) {
        List<VerificationCodeConfig.VerificationCode> verificationCodes = verificationCodeConfig.getVerificationCodes();
        if (verificationCodes == null || verificationCodes.size() == 0) {
            BizException.error(ErrorCodeEnum.UNSUPPORTED_VERIFICATION_CODE_TYPE);
        }
        // 判断是否支持此验证码类型
        VerificationCodeConfig.VerificationCode verificationCode = verificationCodes.stream().filter(e -> e != null && e.getName().equals(verificationCodeTypeName)).findFirst().orElse(null);
        AssertUtils.asserter().assertNull(verificationCode).elseThrow(ErrorCodeEnum.UNSUPPORTED_VERIFICATION_CODE_TYPE);
        // 枚举解析
        VerificationCodeSendModeEnum verificationCodeSendModeEnum = VerificationCodeSendModeEnum.valueOf(verificationCode.getSendMode());
        AssertUtils.asserter().assertNull(verificationCode).elseThrow(ErrorCodeEnum.UNSUPPORTED_VERIFICATION_CODE_TYPE);
        RedisKeyPrefixEnum redisKeyPrefixEnum = RedisKeyPrefixEnum.valueOf(verificationCode.getKeyPrefix());
        AssertUtils.asserter().assertNotNull(verificationCode).elseThrow(ErrorCodeEnum.UNSUPPORTED_VERIFICATION_CODE_TYPE);
        // 判断缓存中是否已有验证码
        String key = redisKeyPrefixEnum.getPrefix() + to;
        AssertUtils.asserter().assertNull(redisUtils.get(key)).elseThrow(ErrorCodeEnum.VERIFICATION_CODE_HAD_SENT);
        // 生成验证码，存入缓存
        String verificationCodeStr = RandomStringUtils.random(verificationCode.getDigits(), false, true);
        redisUtils.set(key, verificationCodeStr, TimeUnit.MINUTES.toSeconds(verificationCode.getExpireTimeInMinute()));
        // 发送验证码
        boolean isSend = false;
        switch (verificationCodeSendModeEnum) {
            case PHONE:
                isSend = sendByPhone(to, verificationCodeStr, verificationCode);
                break;
            case MAIL:
                isSend = sendByMail(to, verificationCodeStr, verificationCode);
                break;
            default:
                log.info("不支持的验证码发送方式：" + verificationCodeSendModeEnum.name());
        }
        // 未发送成功，删除缓存
        if (!isSend) {
            redisUtils.delete(key);
            BizException.error(ErrorCodeEnum.VERIFICATION_CODE_SEND_FAIL);
        }
    }

    private boolean sendByPhone(String to, String verificationCodeStr, VerificationCodeConfig.VerificationCode verificationCode) {
        try {
            String content = verificationCode.getContent().replaceAll("verificationCode", verificationCodeStr)
                    .replaceAll("expireTimeInMinute", String.valueOf(verificationCode.getExpireTimeInMinute()));
            log.info("phone verification code: " + content);
        } catch (Exception e) {
            log.info(String.format("验证码发送异常，接收方：%s，验证码：%s，验证码配置：%s", to, verificationCodeStr, verificationCode), e);
            return false;
        }
        return true;
    }

    private boolean sendByMail(String to, String verificationCodeStr, VerificationCodeConfig.VerificationCode verificationCode) {
        try {
            String content = verificationCode.getContent().replaceAll("verificationCode", verificationCodeStr)
                    .replaceAll("expireTimeInMinute", String.valueOf(verificationCode.getExpireTimeInMinute()));
            sendMailUtils.sendSimpleMail(to, verificationCode.getTitle(), content);
        } catch (Exception e) {
            log.info(String.format("验证码发送异常，接收方：%s，验证码：%s，验证码配置：%s", to, verificationCodeStr, verificationCode), e);
            return false;
        }
        return true;
    }
}
