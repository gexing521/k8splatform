package com.sdjtu.platform.modules.quartz.service.dto;

import com.sdjtu.platform.annotation.Query;
import lombok.Data;

/**
 *
 * @Author: ytuan
 * @Date: 2019-10-12  19:20
 */
@Data
public class JobQueryCriteria {

    @Query(type = Query.Type.INNER_LIKE)
    private String jobName;

    @Query
    private Boolean isSuccess;
}
