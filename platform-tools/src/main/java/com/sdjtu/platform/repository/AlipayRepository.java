package com.sdjtu.platform.repository;

import com.sdjtu.platform.domain.AlipayConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * comment:
 * </p>
 *
 * @author: ytuan
 * @Date 2019-10-12 14:23
 */
public interface AlipayRepository extends JpaRepository<AlipayConfig,Long>  {

}
