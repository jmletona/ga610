package com.jmletona.ga610.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "video")
@Getter
@Setter
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_video")
    private Integer idVideo;

    @Column(name = "url")
    private String url;

    @Column(name = "created")
    private Timestamp created;

    @Column(name = "id_person")
    private Integer idPerson;

    /*@ManyToOne
    @JoinColumn(name = "id_person")
    private Person person;*/
}
