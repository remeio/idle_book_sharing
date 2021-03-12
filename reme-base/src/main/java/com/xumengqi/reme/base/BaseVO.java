package com.xumengqi.reme.base;

import com.google.gson.Gson;

/**
 * 基础 VO
 * @author xumengqi
 * @date 2021/3/9 17:51
 */
public class BaseVO {
    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
