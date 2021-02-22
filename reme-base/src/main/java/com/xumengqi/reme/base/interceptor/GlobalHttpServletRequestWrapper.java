package com.xumengqi.reme.base.interceptor;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

/**
 * 全局 HttpServletRequestWrapper
 * 提供修改 params，添加
 *
 * @author xumengqi
 * @date 2021/2/21 17:22
 */
public class GlobalHttpServletRequestWrapper extends HttpServletRequestWrapper {
    private final Map<String, String> headers = new HashMap<>();

    public GlobalHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.put(headerName, request.getHeader(headerName));
        }
    }

    @Override
    public Enumeration<String> getHeaders(String name) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        return new Enumeration<String>() {
            @Override
            public boolean hasMoreElements() {
                return atomicInteger.get() > 0;
            }

            @Override
            public String nextElement() {
                atomicInteger.decrementAndGet();
                return getHeader(name);
            }
        };
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        Set<String> keys = headers.keySet();
        Iterator<String> iterator = keys.iterator();
        return new Enumeration<String>() {
            @Override
            public boolean hasMoreElements() {
                return iterator.hasNext();
            }

            @Override
            public String nextElement() {
                return iterator.next();
            }
        };
    }

    @Override
    public String getHeader(String name) {
        return headers.get(name);
    }

    public void addHeader(String name, String value) {
        headers.put(name, value);
    }
}
