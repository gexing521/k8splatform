package com.sdjtu.platform.modules.system.service.dto;

import com.sdjtu.platform.annotation.Query;
import lombok.Data;

/**
 *
 * @Author: ytuan
 * @Date: 2019-10-12  15:46
 */
@Data
public class DictDetailQueryCriteria {

    @Query(type = Query.Type.INNER_LIKE)
    private String label;

    @Query(propName = "name",joinName = "dict")
    private String dictName;
}