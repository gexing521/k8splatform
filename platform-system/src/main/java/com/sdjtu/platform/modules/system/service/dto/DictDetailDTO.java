package com.sdjtu.platform.modules.system.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @Author: ytuan
 * @Date: 2019-10-12  15:46
 */
@Data
public class DictDetailDTO implements Serializable {

    private Long id;

    /**
     * 字典标签
     */
    private String label;

    /**
     * 字典值
     */
    private String value;

    /**
     * 排序
     */
    private String sort;
}