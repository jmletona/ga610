package com.jmletona.ga610.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SocialNetworkDTO {
    private Integer idSocialNetwork;
    private String url;
    private String type;
    private Date created;
}
