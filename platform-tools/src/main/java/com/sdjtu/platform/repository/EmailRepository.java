package com.sdjtu.platform.repository;

import com.sdjtu.platform.domain.EmailConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * comment:
 * </p>
 *
 * @author: ytuan
 * @Date 2019-10-12 14:25
 */
public interface EmailRepository extends JpaRepository<EmailConfig, Long> {

}
