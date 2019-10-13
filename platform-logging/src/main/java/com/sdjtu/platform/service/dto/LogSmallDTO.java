package com.sdjtu.platform.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * <p>
 * comment:
 * </p>
 *
 * @author: ytuan
 * @Date 2019-10-12 11:17
 */
@Data
public class LogSmallDTO implements Serializable {

    /**
     * 描述
     */
    private String description;

    /**
     * 请求ip
     */
    private String requestIp;

    /**
     * 请求耗时
     */
    private Long time;

    private String address;

    /**
     * 创建日期
     */
    private Timestamp createTime;
}
