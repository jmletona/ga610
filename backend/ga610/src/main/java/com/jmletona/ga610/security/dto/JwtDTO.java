package com.jmletona.ga610.security.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
@Setter
public class JwtDTO {
    private String token;
    private String bearer = "Bearer";
    private String user;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDTO(String token, String user, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.user = user;
        this.authorities = authorities;
    }
}
