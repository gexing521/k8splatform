package com.sdjtu.platform.modules.system.service.dto;

import com.sdjtu.platform.annotation.Query;
import lombok.Data;

/**
 *
 * @Author: ytuan
 * @Date: 2019-10-12  15:44
 */
@Data
public class RoleQueryCriteria {

    // 多字段模糊
    @Query(blurry = "name,remark")
    private String blurry;
}
