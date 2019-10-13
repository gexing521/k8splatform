package com.sdjtu.platform.service;

import com.sdjtu.platform.domain.GenConfig;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * <p>
 * comment:
 * </p>
 *
 * @author: ytuan
 * @Date 2019-10-12 10:51
 */
@CacheConfig(cacheNames = "genConfig")
public interface GenConfigService {
    /**
     * find
     * @return
     */
    @Cacheable(key = "'1'")
    GenConfig find();

    /**
     * update
     * @param genConfig
     * @return
     */
    @CacheEvict(allEntries = true)
    GenConfig update(GenConfig genConfig);
}
