package com.sdjtu.platform.repository;

import com.sdjtu.platform.domain.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * comment:
 * </p>
 *
 * @author: ytuan
 * @Date 2019-10-12 14:27
 */
public interface VerificationCodeRepository extends JpaRepository<VerificationCode, Long> {

    /**
     * 获取有效的验证码
     *
     * @param scenes 业务场景，如重置密码，重置邮箱等等
     * @param type
     * @param value
     * @return
     */
    VerificationCode findByScenesAndTypeAndValueAndStatusIsTrue(String scenes, String type, String value);
}