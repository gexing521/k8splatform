package com.sdjtu.platform.modules.system.repository;

import com.sdjtu.platform.modules.system.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 * @Author: ytuan
 * @Date: 2019-10-12  15:41
 */
public interface JobRepository extends JpaRepository<Job, Long>, JpaSpecificationExecutor {
}