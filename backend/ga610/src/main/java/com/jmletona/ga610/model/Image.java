package com.jmletona.ga610.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "image")
@Getter
@Setter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_image")
    private Integer idImage;

    @Column(name = "url")
    private String url;

    @Column(name = "updated")
    private Timestamp updated;

    @Column(name = "id_person")
    private Integer idPerson;
}
