package com.sdjtu.platform.modules.system.repository;

import com.sdjtu.platform.modules.system.domain.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

/**
 *
 * @Author: ytuan
 * @Date: 2019-10-12  15:39
 */
public interface DeptRepository extends JpaRepository<Dept, Long>, JpaSpecificationExecutor {

    /**
     * findByPid
     * @param id
     * @return
     */
    List<Dept> findByPid(Long id);

    @Query(value = "select name from dept where id = ?1",nativeQuery = true)
    String findNameById(Long id);

    Set<Dept> findByRoles_Id(Long id);
}