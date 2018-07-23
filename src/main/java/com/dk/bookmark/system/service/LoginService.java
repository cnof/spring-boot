package com.dk.bookmark.system.service;

import com.dk.bookmark.common.utils.Result;

/**
 * @author : dukang
 * @date: 2018/7/17 09:56
 * @description:
 */
public interface LoginService {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    Result login(String username, String password);
}
