package com.dk.bookmark.system.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author : dukang
 * @date: 2018/7/16 19:26
 * @description:
 */
@Data
public class UserDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long userId;

    private String username;

    private String name;

    private String password;

    private Long deptId;

    private String deptName;

    private String email;

    private String mobile;

    private Integer status;

    private Long userIdCreate;

    private Date gmtCreate;

    private Date gmtModified;

    private List<Long> roleIds;

    private Long sex;

    private Date birth;

    private String liveAddress;

    private String hobby;

    private String province;

    private String city;

    private String district;

}
