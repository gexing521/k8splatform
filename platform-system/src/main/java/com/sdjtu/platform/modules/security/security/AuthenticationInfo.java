package com.sdjtu.platform.modules.security.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 *
 * @Author: ytuan
 * @Date: 2019-10-12  19:07
 */
@Getter
@AllArgsConstructor
public class AuthenticationInfo implements Serializable {

    private final String token;

    private final JwtUser user;
}
