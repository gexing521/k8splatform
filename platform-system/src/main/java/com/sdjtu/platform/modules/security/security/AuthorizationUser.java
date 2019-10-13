package com.sdjtu.platform.modules.security.security;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @Author: ytuan
 * @Date: 2019-10-12  19:07
 */
@Getter
@Setter
@Data
public class AuthorizationUser {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String code;

    private String uuid = "";

    @Override
    public String toString() {
        return "{username=" + username + ", password= ******}";
    }
}
