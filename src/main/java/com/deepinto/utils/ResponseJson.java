package com.deepinto.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Ming
 * @描述 将返回值键值对数组转化为Json
 */
public class ResponseJson {

    public static String responseJson(String[] key, String[] value) {

        if (key.length == 0 && value.length == 0) {
            throw new IllegalArgumentException("数组不能为空");
        }

        if (key.length != value.length) {
            throw new IllegalArgumentException("数组键值对不对称");
        }

        JSONObject jsonObject = new JSONObject();

        int x = value.length;

        for (int i = 0; i < x; i++) {
            jsonObject.put(key[i], value[i]);
        }

        return jsonObject.toJSONString();

    }
}
