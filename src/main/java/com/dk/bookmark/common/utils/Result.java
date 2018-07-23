package com.dk.bookmark.common.utils;

import java.util.HashMap;

/**
 * @author : dukang
 * @date: 2018/7/16 18:58
 * @description:
 */
public class Result extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public Result() {
        put("code", 0);
        put("msg", "操作成功");
    }

    public static Result error() {
        return error(1, "操作失败");
    }

    public static Result error(String msg) {
        return error(500, msg);
    }

    public static Result error(int code, String msg) {
        Result result = new Result();
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

}
