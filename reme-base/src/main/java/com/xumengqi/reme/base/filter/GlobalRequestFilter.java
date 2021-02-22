package com.xumengqi.reme.base.filter;

import com.xumengqi.reme.base.interceptor.GlobalHttpServletRequestWrapper;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author xumengqi
 * @date 2021/2/21 17:57
 */
@Component
public class GlobalRequestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(new GlobalHttpServletRequestWrapper((HttpServletRequest) servletRequest), servletResponse);
    }
}
