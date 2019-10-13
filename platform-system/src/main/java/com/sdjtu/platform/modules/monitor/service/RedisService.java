package com.sdjtu.platform.modules.monitor.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author: ytuan
 * @Date: 2019-10-12  19:24
 */
public interface RedisService {

    /**
     * findById
     *
     * @param key
     * @return
     */
    Page findByKey(String key, Pageable pageable);

    /**
     * 查询验证码的值
     *
     * @param key
     * @return
     */
    String getCodeVal(String key);

    /**
     * 保存验证码
     *
     * @param key
     * @param val
     */
    void saveCode(String key, Object val);

    /**
     * delete
     *
     * @param key
     */
    void delete(String key);

    /**
     * 清空所有缓存
     */
    void flushdb();
}
