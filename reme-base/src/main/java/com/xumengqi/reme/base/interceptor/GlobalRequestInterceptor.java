package com.xumengqi.reme.base.interceptor;

import com.xumengqi.reme.base.constant.HeaderConstant;
import com.xumengqi.reme.base.util.HttpServletRequestUtils;
import org.apache.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局请求拦截器
 * @author xumengqi
 * @date 2021/1/3 18:00
 */
@Order(1)
@Component
public class GlobalRequestInterceptor implements HandlerInterceptor {

    private static final Logger log = Logger.getLogger(GlobalRequestInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 不拦截非 controller
        if (!HandlerMethod.class.equals(handler.getClass())) {
            return true;
        }
        HttpServletRequestUtils.reflectPutHeader(request, HeaderConstant.IP_ADDRESS, getIpAddr(request));
        return true;
    }

    /**
     * 获取真实IP
     * @param request /
     * @return 真实IP
     */
    public  String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if ("0:0:0:0:0:0:0:1".equals(ip)) {
            ip = "127.0.0.1";
        }
        if (ip.split(",").length > 1) {
            ip = ip.split(",")[0];
        }
        return ip;
    }
}
