package com.dk.bookmark.system.service.impl;

import com.dk.bookmark.system.dao.MenuMapper;
import com.dk.bookmark.system.service.MenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: dukang
 * @date: 2018/7/20 16:43
 * @description:
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Set<String> listPerms(Long userId) {
        List<String> perms = menuMapper.listUserPerms(userId);
        Set<String> permSet = new HashSet<>();
        for (String perm : perms) {
            if (StringUtils.isNotBlank(perm)) {
                permSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permSet;
    }
}
