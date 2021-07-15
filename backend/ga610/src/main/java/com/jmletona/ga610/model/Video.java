package com.jmletona.ga610.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "VIDEO")
@Getter
@Setter
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_video")
    private int idVideo;

    @Column(name = "url")
    private String url;

    /*
    private Person person;
    */

    @Column(name = "created")
    private Date created;

}
