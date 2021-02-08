package com.xumengqi.reme.base;

import com.google.gson.Gson;

/**
 * @author xumengqi
 * @date 2020/12/28 19:26
 */
public class BaseRequest {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    private String operator;

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
