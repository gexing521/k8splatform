package com.sdjtu.platform.modules.system.service.dto;

import com.sdjtu.platform.annotation.Query;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @Author: ytuan
 * @Date: 2019-10-12  15:44
 */
@Data
public class UserQueryCriteria implements Serializable {

    @Query
    private Long id;

    @Query(propName = "id", type = Query.Type.IN, joinName = "dept")
    private Set<Long> deptIds;

    // 多字段模糊
    @Query(blurry = "email,username")
    private String blurry;

    @Query
    private Boolean enabled;

    private Long deptId;
}
