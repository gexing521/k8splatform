package com.sdjtu.platform.modules.system.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @Author: ytuan
 * @Date: 2019-10-12  15:47
 */
@Data
public class DeptSmallDTO implements Serializable {

    /**
     * ID
     */
    private Long id;

    /**
     * 名称
     */
    private String name;
}