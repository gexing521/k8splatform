package com.sdjtu.platform.service;

import com.sdjtu.platform.domain.GenConfig;
import com.sdjtu.platform.domain.vo.ColumnInfo;

import java.util.List;

/**
 * <p>
 * comment:
 * </p>
 *
 * @author: ytuan
 * @Date 2019-10-12 10:50
 */
public interface GeneratorService {

    /**
     * 查询数据库元数据
     *
     * @param name
     * @param startEnd
     * @return
     */
    Object getTables(String name, int[] startEnd);

    /**
     * 得到数据表的元数据
     *
     * @param name
     * @return
     */
    Object getColumns(String name);

    /**
     * 生成代码
     *
     * @param columnInfos
     * @param genConfig
     * @param tableName
     */
    void generator(List<ColumnInfo> columnInfos, GenConfig genConfig, String tableName);
}
