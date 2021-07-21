package com.jmletona.ga610.security.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
public class UserLogin {

    @NotBlank
    private String user;

    @NotBlank
    private String password;
}
