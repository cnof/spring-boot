package com.dk.bookmark.system.controller;

import com.dk.bookmark.common.utils.Result;
import com.dk.bookmark.system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

/**
 * @author : dukang
 * @date: 2018/7/16 18:57
 * @description:
 */
@Controller
public class LoginController {

    @Value("${mark.uploadPath}")
    private String path;
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody
    Result login(String username, String password) {
        return loginService.login(username, password);
    }
}
