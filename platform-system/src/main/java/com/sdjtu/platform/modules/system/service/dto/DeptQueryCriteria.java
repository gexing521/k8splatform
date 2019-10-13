package com.sdjtu.platform.modules.system.service.dto;

import com.sdjtu.platform.annotation.Query;
import lombok.Data;

import java.util.Set;

/**
 *
 * @Author: ytuan
 * @Date: 2019-10-12  15:45
 */
@Data
public class DeptQueryCriteria{

    @Query(type = Query.Type.IN, propName="id")
    private Set<Long> ids;

    @Query(type = Query.Type.INNER_LIKE)
    private String name;

    @Query
    private Boolean enabled;

    @Query
    private Long pid;
}