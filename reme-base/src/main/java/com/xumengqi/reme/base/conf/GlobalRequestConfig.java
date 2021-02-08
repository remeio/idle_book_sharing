package com.xumengqi.reme.base.conf;

import com.xumengqi.reme.base.interceptor.GlobalRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xumengqi
 * @date 2021/1/3 18:04
 */
@Configuration
public class GlobalRequestConfig implements WebMvcConfigurer {
    @Autowired
    private GlobalRequestInterceptor globalRequestInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(globalRequestInterceptor);
        registration.addPathPatterns("/**");
    }
}
