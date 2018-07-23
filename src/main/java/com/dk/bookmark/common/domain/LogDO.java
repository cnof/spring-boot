package com.dk.bookmark.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author : dukang
 * @date: 2018/7/12 17:39
 * @description:
 */
@Data
public class LogDO {

    private Long id;

    private Long userId;

    private String userName;

    private String operation;

    private Integer time;

    private String method;

    private String params;

    private String ip;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;
}
