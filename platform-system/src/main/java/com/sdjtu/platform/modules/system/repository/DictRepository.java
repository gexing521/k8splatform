package com.sdjtu.platform.modules.system.repository;

import com.sdjtu.platform.modules.system.domain.Dict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 * @Author: ytuan
 * @Date: 2019-10-12  15:40
 */
public interface DictRepository extends JpaRepository<Dict, Long>, JpaSpecificationExecutor {
}