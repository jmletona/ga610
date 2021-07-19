package com.jmletona.ga610.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "social_network")
@Getter
@Setter
public class SocialNetwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_social_network")
    private int idSocialNetwork;

    @Column(name = "url")
    private String url;

    @Column(name = "social_network_type",columnDefinition = "enum('FACEBOOK','INSTAGRAM','TWITTER')")
    private String type;

    @Column(name = "id_person")
    private Integer idPerson;

    @Column(name = "created")
    private Date created;
}
