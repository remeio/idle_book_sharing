package com.xumengqi.reme.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author xumengqis
 * @date 2021/1/4 11:42
 */
@PropertySource(value = {"classpath:application.properties"})
@ConfigurationProperties(prefix = "verification-code")
@Component
public class VerificationCodeConfig {
    private String prefix;

    private long expireTime;

    private int digits;

    private String mailFrom;

    private String mailSubject;

    private String mailContent;

    public String getPrefix() {
        return this.prefix;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public int getDigits() {
        return this.digits;
    }

    public String getMailFrom() {
        return this.mailFrom;
    }

    public String getMailSubject() {
        return this.mailSubject;
    }

    public String getMailContent() {
        return this.mailContent;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    public void setDigits(int digits) {
        this.digits = digits;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }
}
