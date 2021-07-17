package com.jmletona.ga610.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "REVIEW")
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_review")
    private int idReview;

    @Column(name = "ranking", columnDefinition = "enum('POOR','FAIR','GOOD','VERY GOOD','EXCELLENT')")
    private String ranking;

    @Column(name = "review_status", columnDefinition = "enum('PENDING','APPROVED','DENIED')")
    private String status;

    @Column(name = "review_comment")
    private String comment;

    /*
    private Person person;
    private CampusUser user;
    */

    @Column(name = "created")
    private Date created;
}
