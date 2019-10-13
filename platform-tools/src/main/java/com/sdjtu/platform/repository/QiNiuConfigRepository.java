package com.sdjtu.platform.repository;

import com.sdjtu.platform.domain.QiniuConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * <p>
 * comment:
 * </p>
 *
 * @author: ytuan
 * @Date 2019-10-12 14:26
 */
public interface QiNiuConfigRepository extends JpaRepository<QiniuConfig, Long> {


    @Modifying
    @Query(value = "update qiniu_content set type = ?1", nativeQuery = true)
    void update(String type);

}
