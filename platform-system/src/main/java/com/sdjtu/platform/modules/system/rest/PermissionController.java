package com.sdjtu.platform.modules.system.rest;

import com.sdjtu.platform.exception.handler.BadRequestException;
import com.sdjtu.platform.aop.log.Log;
import com.sdjtu.platform.modules.system.domain.Permission;
import com.sdjtu.platform.modules.system.service.PermissionService;
import com.sdjtu.platform.modules.system.service.dto.PermissionDTO;
import com.sdjtu.platform.modules.system.service.dto.PermissionQueryCriteria;
import com.sdjtu.platform.modules.system.service.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: ytuan
 * @Date: 2019-10-12  19:32
 */
@RestController
@RequestMapping("api")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private PermissionMapper permissionMapper;

    private static final String ENTITY_NAME = "permission";

    /**
     * 返回全部的权限，新增角色时下拉选择
     *
     * @return
     */
    @GetMapping(value = "/permissions/tree")
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_CREATE','PERMISSION_EDIT','ROLES_SELECT','ROLES_ALL')")
    public ResponseEntity getTree() {
        return new ResponseEntity(permissionService.getPermissionTree(permissionService.findByPid(0L)), HttpStatus.OK);
    }

    @Log("查询权限")
    @GetMapping(value = "/permissions")
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_SELECT')")
    public ResponseEntity getPermissions(PermissionQueryCriteria criteria) {
        List<PermissionDTO> permissionDTOS = permissionService.queryAll(criteria);
        return new ResponseEntity(permissionService.buildTree(permissionDTOS), HttpStatus.OK);
    }

    @Log("新增权限")
    @PostMapping(value = "/permissions")
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_CREATE')")
    public ResponseEntity create(@Validated @RequestBody Permission resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity(permissionService.create(resources), HttpStatus.CREATED);
    }

    @Log("修改权限")
    @PutMapping(value = "/permissions")
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_EDIT')")
    public ResponseEntity update(@Validated(Permission.Update.class) @RequestBody Permission resources) {
        permissionService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除权限")
    @DeleteMapping(value = "/permissions/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','PERMISSION_ALL','PERMISSION_DELETE')")
    public ResponseEntity delete(@PathVariable Long id) {
        List<Permission> permissions = permissionService.findByPid(id);
        Set<Permission> permissionSet = new HashSet<>();
        permissionSet.add(permissionMapper.toEntity(permissionService.findById(id)));
        permissionSet = permissionService.getDeletePermission(permissions, permissionSet);
        permissionService.delete(permissionSet);
        return new ResponseEntity(HttpStatus.OK);
    }
}
