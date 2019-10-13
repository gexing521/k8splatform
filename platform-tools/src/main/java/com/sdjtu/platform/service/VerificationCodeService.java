package com.sdjtu.platform.service;

import com.sdjtu.platform.domain.VerificationCode;
import com.sdjtu.platform.domain.vo.EmailVo;

/**
 * <p>
 * comment:
 * </p>
 *
 * @author: ytuan
 * @Date 2019-10-12 14:27
 */
public interface VerificationCodeService {

    /**
     * 发送邮件验证码
     * @param code
     */
    EmailVo sendEmail(VerificationCode code);

    /**
     * 验证
     * @param code
     */
    void validated(VerificationCode code);
}
