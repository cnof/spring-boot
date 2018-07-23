package com.dk.bookmark.common.utils;

import com.alibaba.fastjson.JSON;

/**
 * @author : dukang
 * @date: 2018/7/12 17:54
 * @description:
 */
public class JsonUtils {

    private JsonUtils() {
    }

    /**
     * bean转json
     */
    public static String beanToJson(Object object) {
        if (null != object) {
            return JSON.toJSONString(object);
        } else {
            return null;
        }
    }
}
