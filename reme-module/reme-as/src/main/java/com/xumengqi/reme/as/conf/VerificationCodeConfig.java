package com.xumengqi.reme.as.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

/**
 * @author xumengqi
 * @date 2021/2/27 19:07
 */
@PropertySource(value = {"classpath:conf/verification-code.properties"})
@ConfigurationProperties(prefix = "verification-code")
@Configuration
public class VerificationCodeConfig {
    private List<VerificationCode> verificationCodes;

    public List<VerificationCode> getVerificationCodes() {
        return verificationCodes;
    }

    public void setVerificationCodes(List<VerificationCode> verificationCodes) {
        this.verificationCodes = verificationCodes;
    }

    public static class VerificationCode {
        private String name;

        private String description;

        private Integer digits;

        private Long expireTimeInMinute;

        private String title;

        private String content;

        private String sendMode;

        private String keyPrefix;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Long getExpireTimeInMinute() {
            return expireTimeInMinute;
        }

        public void setExpireTimeInMinute(Long expireTimeInMinute) {
            this.expireTimeInMinute = expireTimeInMinute;
        }

        public String getSendMode() {
            return sendMode;
        }

        public void setSendMode(String sendMode) {
            this.sendMode = sendMode;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Integer getDigits() {
            return digits;
        }

        public void setDigits(Integer digits) {
            this.digits = digits;
        }

        public String getKeyPrefix() {
            return keyPrefix;
        }

        public void setKeyPrefix(String keyPrefix) {
            this.keyPrefix = keyPrefix;
        }

        @Override
        public String toString() {
            return "VerificationCode{" +
                    "name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", digits=" + digits +
                    ", expireTimeInMinute=" + expireTimeInMinute +
                    ", title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    ", sendMode='" + sendMode + '\'' +
                    ", keyPrefix='" + keyPrefix + '\'' +
                    '}';
        }
    }
}