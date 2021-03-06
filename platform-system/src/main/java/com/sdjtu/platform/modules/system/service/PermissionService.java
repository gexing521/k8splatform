package com.sdjtu.platform.modules.system.service;

import com.sdjtu.platform.modules.system.domain.Permission;
import com.sdjtu.platform.modules.system.service.dto.PermissionDTO;
import com.sdjtu.platform.modules.system.service.dto.PermissionQueryCriteria;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Set;

/**
 *
 * @Author: ytuan
 * @Date: 2019-10-12  15:29
 */
@CacheConfig(cacheNames = "permission")
public interface PermissionService {

    /**
     * get
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    PermissionDTO findById(long id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    PermissionDTO create(Permission resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(Permission resources);

    /**
     * delete
     * @param permissions
     */
    @CacheEvict(allEntries = true)
    void delete(Set<Permission> permissions);

    /**
     * permission tree
     * @return
     */
    @Cacheable(key = "'tree'")
    Object getPermissionTree(List<Permission> permissions);

    /**
     * findByPid
     * @param pid
     * @return
     */
    @Cacheable(key = "'pid:'+#p0")
    List<Permission> findByPid(long pid);

    /**
     * build Tree
     * @param permissionDTOS
     * @return
     */
    @Cacheable
    Object buildTree(List<PermissionDTO> permissionDTOS);

    /**
     * queryAll
     * @param criteria
     * @return
     */
    @Cacheable
    List<PermissionDTO> queryAll(PermissionQueryCriteria criteria);

    Set<Permission> getDeletePermission(List<Permission> permissions, Set<Permission> permissionSet);
}
