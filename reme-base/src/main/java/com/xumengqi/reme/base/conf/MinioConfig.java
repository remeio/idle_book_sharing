package com.xumengqi.reme.base.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Minio 配置类
 * @author xumengqi
 */
@PropertySource(value = {"classpath:conf/minio.properties"})
@ConfigurationProperties(prefix = "minio")
@Configuration
public class MinioConfig {
    private String url;

    private String accessKey;

    private String accessSecret;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    public void setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
    }
}
