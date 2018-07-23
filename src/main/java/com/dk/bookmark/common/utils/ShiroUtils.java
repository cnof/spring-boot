package com.dk.bookmark.common.utils;

import com.dk.bookmark.system.domain.UserDO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: dukang
 * @date: 2018/7/20 16:28
 * @description:
 */
public class ShiroUtils {

    private ShiroUtils() {
    }

    @Autowired
    private static SessionDAO sessionDAO;

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static UserDO getUser() {
        Object object = getSubject().getPrincipal();
        return (UserDO) object;
    }

    public static Long getUserId() {
        return getUser().getUserId();
    }

    public static void logout() {
        getSubject().logout();
    }
}
