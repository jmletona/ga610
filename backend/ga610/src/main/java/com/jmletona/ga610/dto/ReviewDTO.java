package com.jmletona.ga610.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReviewDTO {
    private Integer idReview;
    private Integer idPerson;
    private Integer idUser;
    private String ranking;
    private String status;
    private String comment;
    private Integer idPerson;
    private Integer idUser;
    private Date created;
}
