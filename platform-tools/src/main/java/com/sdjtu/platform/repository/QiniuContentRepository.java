package com.sdjtu.platform.repository;

import com.sdjtu.platform.domain.QiniuContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * <p>
 * comment:
 * </p>
 *
 * @author: ytuan
 * @Date 2019-10-12 14:27
 */
public interface QiniuContentRepository extends JpaRepository<QiniuContent, Long>, JpaSpecificationExecutor {

    /**
     * 根据key查询
     *
     * @param key
     * @return
     */
    QiniuContent findByKey(String key);
}