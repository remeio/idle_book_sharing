package com.xumengqi.reme.base;

import com.google.gson.Gson;

/**
 * @author xumengqi
 * @date 2020/12/28 19:26
 */
public class BaseRequest {
    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
