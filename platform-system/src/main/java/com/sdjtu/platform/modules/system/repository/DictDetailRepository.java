package com.sdjtu.platform.modules.system.repository;

import com.sdjtu.platform.modules.system.domain.DictDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: ytuan
 * @Date: 2019-10-12  15:39
 */
public interface DictDetailRepository extends JpaRepository<DictDetail, Long>, JpaSpecificationExecutor {
}