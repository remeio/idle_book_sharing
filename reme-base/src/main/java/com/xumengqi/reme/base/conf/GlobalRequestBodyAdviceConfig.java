package com.xumengqi.reme.base.conf;

import com.xumengqi.reme.base.BaseRequest;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author xumengqi
 * @date 2021/2/22 19:34
 */
@ControllerAdvice
public class GlobalRequestBodyAdviceConfig implements RequestBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        if (body instanceof BaseRequest) {
            BaseRequest baseRequest = (BaseRequest) body;
            baseRequest.setOperatorId(null);
            baseRequest.setIpAddress(null);
            Optional.ofNullable(inputMessage.getHeaders().get("operatorId")).map(e -> e.get(0)).ifPresent(e -> {
                baseRequest.setOperatorId(Long.parseLong(e));
            });
            Optional.ofNullable(inputMessage.getHeaders().get("ipAddress")).map(e -> e.get(0)).ifPresent(baseRequest::setIpAddress);
        }
        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }


}
