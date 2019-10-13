package com.sdjtu.platform.modules.quartz.repository;

import com.sdjtu.platform.modules.quartz.domain.QuartzLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 * @Author: ytuan
 * @Date: 2019-10-12  19:17
 */
public interface QuartzLogRepository extends JpaRepository<QuartzLog,Long>, JpaSpecificationExecutor {

}
