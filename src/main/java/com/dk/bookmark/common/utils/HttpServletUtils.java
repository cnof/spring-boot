package com.dk.bookmark.common.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : dukang
 * @date : 2018/7/16 20:02
 * @description : 判断请求是否是ajax请求
 */
public class HttpServletUtils {

    private HttpServletUtils() {
    }
    public static boolean isAjax(HttpServletRequest request) {
        String headerRequest = "x-requested-with";
        boolean isAjaxRequest = false;
        if (!StringUtils.isBlank(request.getHeader(headerRequest))
                && "XMLHttpRequest".equals(request.getHeader(headerRequest))) {
            isAjaxRequest = true;
        }
        return isAjaxRequest;
    }
}
