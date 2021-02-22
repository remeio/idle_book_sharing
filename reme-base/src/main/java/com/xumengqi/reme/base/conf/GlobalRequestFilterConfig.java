package com.xumengqi.reme.base.conf;

import com.xumengqi.reme.base.filter.GlobalRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xumengqi
 * @date 2021/2/21 17:41
 */
@Configuration
public class GlobalRequestFilterConfig {
    @Autowired
    private GlobalRequestFilter globalRequestFilter;

    @Bean
    public FilterRegistrationBean<GlobalRequestFilter> globalRequestFilterFilterRegistrationBean() {
        FilterRegistrationBean<GlobalRequestFilter> registrationBean = new FilterRegistrationBean<>();
        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/*");
        registrationBean.setUrlPatterns(urlPatterns);
        registrationBean.setFilter(globalRequestFilter);
        return registrationBean;
    }

}
