package com.xumengqi.reme.interceptor;

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
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new GlobalRequestInterceptor());
        registration.addPathPatterns("/**");
    }
}
