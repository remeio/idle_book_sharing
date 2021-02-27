package com.xumengqi.reme.base.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author xumengqi
 * @date 2021/2/27 22:08
 */
@Component
public class SystemConfig {
    @Value("${access-token.check-time-in-day}")
    private Long accessTokenCheckTimeInDay;

    @Value("${access-token.expire-time-in-day}")
    private Long accessTokenExpireTimeInDay;

    public Long getAccessTokenCheckTimeInDay() {
        return accessTokenCheckTimeInDay;
    }

    public void setAccessTokenCheckTimeInDay(Long accessTokenCheckTimeInDay) {
        this.accessTokenCheckTimeInDay = accessTokenCheckTimeInDay;
    }

    public Long getAccessTokenExpireTimeInDay() {
        return accessTokenExpireTimeInDay;
    }

    public void setAccessTokenExpireTimeInDay(Long accessTokenExpireTimeInDay) {
        this.accessTokenExpireTimeInDay = accessTokenExpireTimeInDay;
    }
}
