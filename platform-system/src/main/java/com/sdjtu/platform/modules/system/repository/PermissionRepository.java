package com.sdjtu.platform.modules.system.repository;

import com.sdjtu.platform.modules.system.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Author: ytuan
 * @Date: 2019-10-12  15:40
 */
public interface PermissionRepository extends JpaRepository<Permission, Long>, JpaSpecificationExecutor {

    /**
     * findByName
     *
     * @param name
     * @return
     */
    Permission findByName(String name);

    /**
     * findByPid
     *
     * @param pid
     * @return
     */
    List<Permission> findByPid(long pid);
}
