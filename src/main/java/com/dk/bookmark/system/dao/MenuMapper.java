package com.dk.bookmark.system.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: dukang
 * @date: 2018/7/20 16:38
 * @description:
 */
@Repository
public interface MenuMapper {

    /**
     * 列出用户权限
     * @param id
     * @return
     */
    List<String> listUserPerms(Long id);
}
