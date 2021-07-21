package com.jmletona.ga610.security.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class NewUser {
    @NotBlank
    private String name;

    @NotBlank
    private String user;

    @Email
    private String email;

    @NotBlank
    private String password;

    private Set<String> roles = new HashSet<>();
}
