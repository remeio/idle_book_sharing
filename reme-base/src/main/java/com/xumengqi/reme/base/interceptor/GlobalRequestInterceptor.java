package com.xumengqi.reme.base.interceptor;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xumengqi
 * @date 2021/1/3 18:00
 */
@Component
public class GlobalRequestInterceptor implements HandlerInterceptor {

    private static final Logger log = Logger.getLogger(GlobalRequestInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }
}
