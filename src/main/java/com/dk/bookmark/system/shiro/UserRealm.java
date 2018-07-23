package com.dk.bookmark.system.shiro;

import com.dk.bookmark.common.utils.ShiroUtils;
import com.dk.bookmark.system.dao.UserMapper;
import com.dk.bookmark.system.domain.UserDO;
import com.dk.bookmark.system.service.MenuService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author : dukang
 * @date: 2018/7/16 18:52
 * @description:
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuService menuService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Long userId = ShiroUtils.getUserId();
        Set<String> perms = menuService.listPerms(userId);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(perms);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        Map<String, Object> map = new HashMap<>(16);
        map.put("username", username);
        //查找用户信息
        List<UserDO> users = userMapper.listUser(map);
        UserDO user = null;
        if (!users.isEmpty()) {
            user = users.get(0);
        }
        //账号不存在
        if (null == user) {
            throw new UnknownAccountException("账号或者密码不正确");
        }
        //密码错误
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("账号或者密码不正确");
        }
        //账号锁定
        if (user.getStatus() == 0) {
            throw new LockedAccountException("账号已锁定，请联系管理员");
        }
        return new SimpleAuthenticationInfo(user, password, getName());
    }
}
