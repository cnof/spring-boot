package com.dk.bookmark.system.service;

import java.util.Set;

/**
 * @author: dukang
 * @date: 2018/7/20 16:42
 * @description:
 */
public interface MenuService {

    /**
     * 列出用户权限
     * @param userId
     * @return
     */
    Set<String> listPerms(Long userId);
}
