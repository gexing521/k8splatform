package com.sdjtu.platform.repository;

import com.sdjtu.platform.domain.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * comment:
 * </p>
 *
 * @author: ytuan
 * @Date 2019-10-12 11:12
 */
@Repository
public interface LogRepository extends JpaRepository<Log, Long>, JpaSpecificationExecutor {

    /**
     * 获取一个时间段的IP记录
     *
     * @param date1
     * @param date2
     * @return
     */
    @Query(value = "select count(*) FROM (select request_ip FROM log where create_time between ?1 and ?2 GROUP BY request_ip) as s", nativeQuery = true)
    Long findIp(String date1, String date2);

    /**
     * findExceptionById
     *
     * @param id
     * @return
     */
    @Query(value = "select exception_detail FROM log where id = ?1", nativeQuery = true)
    String findExceptionById(Long id);
}