package com.jmletona.ga610.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class VideoDTO {
    private Integer idVideo;
    private String url;
    private Date created;
}
