package com.xumengqi.reme.base.util;

import org.apache.tomcat.util.http.MimeHeaders;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;

/**
 * HttpServletRequest 工具类
 * @author xumengqi
 * @date 2021/3/2 17:22
 */
public class HttpServletRequestUtils {
    /**
     * 修改 header 信息
     * @param request /
     * @param key /
     * @param value /
     */
    public static void reflectPutHeader(HttpServletRequest request, String key, String value) throws ReflectiveOperationException {
        Class<? extends HttpServletRequest> requestClass = request.getClass();
        try {
            Field request1 = requestClass.getDeclaredField("request");
            request1.setAccessible(true);
            Object o = request1.get(request);
            Field coyoteRequest = o.getClass().getDeclaredField("coyoteRequest");
            coyoteRequest.setAccessible(true);
            Object o1 = coyoteRequest.get(o);
            Field headers = o1.getClass().getDeclaredField("headers");
            headers.setAccessible(true);
            MimeHeaders o2 = (MimeHeaders) headers.get(o1);
            o2.addValue(key).setString(value);
        } catch (Exception e) {
            throw new ReflectiveOperationException(e);
        }
    }
}
