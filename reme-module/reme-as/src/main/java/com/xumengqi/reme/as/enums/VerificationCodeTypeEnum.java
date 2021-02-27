package com.xumengqi.reme.as.enums;

import com.xumengqi.reme.as.logic.verificationcode.handler.GenerateAble;
import com.xumengqi.reme.as.logic.verificationcode.handler.SendAble;
import com.xumengqi.reme.as.logic.verificationcode.handler.generator.NumberGenerator;
import com.xumengqi.reme.as.logic.verificationcode.handler.sender.MobilePhoneSender;

import java.util.Arrays;

/**
 * @author xumengqi
 * @date 2021/2/27 14:15
 */
public enum VerificationCodeTypeEnum {
    /**
     * 注册验证码
     */
    SIGN_UP("signUp", "注册验证码", NumberGenerator.class, MobilePhoneSender.class),
    ;

    private final String code;

    private final String description;

    private final Class<? extends GenerateAble> generateAbleClass;

    private final Class<? extends SendAble> sendAbleClass;

    VerificationCodeTypeEnum(String code, String description, Class<? extends GenerateAble> generateAbleClass, Class<? extends SendAble> sendAbleClass) {
        this.code = code;
        this.description = description;
        this.generateAbleClass = generateAbleClass;
        this.sendAbleClass = sendAbleClass;
    }

    public Class<? extends GenerateAble> getGenerateAbleClass() {
        return generateAbleClass;
    }

    public Class<? extends SendAble> getSendAbleClass() {
        return sendAbleClass;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static VerificationCodeTypeEnum getByCode(String code) {
        return Arrays.stream(VerificationCodeTypeEnum.values())
                .filter(e -> e.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }
}
