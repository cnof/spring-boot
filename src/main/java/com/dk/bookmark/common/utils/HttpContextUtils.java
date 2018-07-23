package com.dk.bookmark.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : dukang
 * @date: 2018/7/12 17:51
 * @description: 获取request
 */
public class HttpContextUtils {

    private HttpContextUtils() {

    }
    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
}
