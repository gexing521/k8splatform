package com.sdjtu.platform.modules.system.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 *
 * @Author: ytuan
 * @Date: 2019-10-12  15:44
 */
@Data
public class RoleDTO implements Serializable {

    private Long id;

    private String name;

    private String dataScope;

    private Integer level;

    private String remark;

    private Set<PermissionDTO> permissions;

    private Set<MenuDTO> menus;

    private Set<DeptDTO> depts;

    private Timestamp createTime;
}
