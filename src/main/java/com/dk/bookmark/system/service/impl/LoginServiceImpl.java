package com.dk.bookmark.system.service.impl;

import com.dk.bookmark.common.utils.Result;
import com.dk.bookmark.system.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * @author : dukang
 * @date: 2018/7/17 09:56
 * @description:
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public Result login(String username, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
//        try {
            subject.login(token);
            return new Result();
//        } catch (Exception e) {
//            return Result.error("用户名或密码错误");
//        }
    }
}
