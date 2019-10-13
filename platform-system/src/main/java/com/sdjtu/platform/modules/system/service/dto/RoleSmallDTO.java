package com.sdjtu.platform.modules.system.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @Author: ytuan
 * @Date: 2019-10-12  15:44
 */
@Data
public class RoleSmallDTO implements Serializable {

    private Long id;

    private String name;

    private Integer level;

    private String dataScope;
}
