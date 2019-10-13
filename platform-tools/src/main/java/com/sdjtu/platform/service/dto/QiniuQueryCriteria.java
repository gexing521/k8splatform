package com.sdjtu.platform.service.dto;

import com.sdjtu.platform.annotation.Query;
import lombok.Data;

/**
 * <p>
 * comment:
 * </p>
 *
 * @author: ytuan
 * @Date 2019-10-12 14:27
 */
@Data
public class QiniuQueryCriteria{

    @Query(type = Query.Type.INNER_LIKE)
    private String key;
}
