package com.dk.bookmark.system.dao;

import com.dk.bookmark.system.domain.UserDO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: dukang
 * @date: 2018/7/20 16:06
 * @description:
 */
@Repository
public interface UserMapper {

    /**
     * 列出数据库中的用户信息
     * @param map
     * @return
     */
    List<UserDO> listUser(Map<String, Object> map);
}
