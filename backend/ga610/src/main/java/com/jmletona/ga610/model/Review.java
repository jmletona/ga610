package com.jmletona.ga610.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "review")
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_review")
    private int idReview;

    @Column(name = "ranking", columnDefinition = "enum('POOR','FAIR','GOOD','VERY GOOD','EXCELLENT')")
    private String ranking;

    @Column(name = "review_status", columnDefinition = "enum('PENDING','APPROVED','DENIED')")
    private String status;

    @Column(name = "review_comment")
    private String comment;

    @Column(name = "id_person")
    private Integer idPerson;

    @Column(name = "created")
    private Date created;
}
