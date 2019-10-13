package com.sdjtu.platform.modules.quartz.repository;

import com.sdjtu.platform.modules.quartz.domain.QuartzJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 *
 * @Author: ytuan
 * @Date: 2019-10-12  19:18
 */
public interface QuartzJobRepository extends JpaRepository<QuartzJob,Long>, JpaSpecificationExecutor {

    /**
     * 查询启用的任务
     * @return
     */
    List<QuartzJob> findByIsPauseIsFalse();
}
