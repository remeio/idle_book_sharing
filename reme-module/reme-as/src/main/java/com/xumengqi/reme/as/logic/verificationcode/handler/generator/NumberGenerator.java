package com.xumengqi.reme.as.logic.verificationcode.handler.generator;

import com.xumengqi.reme.as.logic.verificationcode.handler.GenerateAble;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * @author xumengqi
 * @date 2021/2/27 15:24
 */
@Component
public class NumberGenerator implements GenerateAble {
    @Override
    public String generateVerificationCode() {
        return RandomStringUtils.random(6, false, true);
    }

    @Override
    public Long generateExpireTime() {
        return 60 * 5L;
    }
}
