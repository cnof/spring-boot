package com.dk.bookmark.common.exception;

import com.dk.bookmark.common.utils.HttpServletUtils;
import com.dk.bookmark.common.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : dukang
 * @date: 2018/7/16 19:21
 * @description:
 */
@RestControllerAdvice
public class BdExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e, HttpServletRequest request) {
        return Result.error(500, e.getMessage());
    }
}
