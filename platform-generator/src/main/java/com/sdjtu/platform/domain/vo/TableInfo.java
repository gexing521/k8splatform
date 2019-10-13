package com.sdjtu.platform.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * comment:表的数据信息
 * </p>
 *
 * @author: ytuan
 * @Date 2019-10-12 10:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableInfo {

    /**
     * 表名称
     **/
    private Object tableName;

    /**
     * 创建日期
     **/
    private Object createTime;

    // 数据库引擎
    private Object engine;

    // 编码集
    private Object coding;

    // 备注
    private Object remark;


}