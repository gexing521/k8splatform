package com.sdjtu.platform.service.dto;

import com.sdjtu.platform.annotation.Query;
import lombok.Data;

/**
 * <p>
 * comment:日志查询类
 * </p>
 *
 * @author: ytuan
 * @Date 2019-10-12 11:15
 */
@Data
public class LogQueryCriteria {

    // 多字段模糊
    @Query(blurry = "username,description,address,requestIp,method,params")
    private String blurry;

    @Query
    private String logType;
}
