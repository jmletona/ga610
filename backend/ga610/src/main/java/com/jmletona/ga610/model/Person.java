package com.jmletona.ga610.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="person")
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private Integer idPerson;


    @Column(name ="is_active")
    private Boolean active;
    @Column(name = "company")
    private String company;

    @Column(name ="person_description")
    private String description;

    @Column(name ="person_name")
    private String name;

    @Column(name ="person_lastname")
    private String lastname;
    @Column(name = "address")
    private String address;

    @Column(name = "created")
    private Date created;

    @Column(name = "id_campus")
    private Integer idCampus;

    @ManyToMany
    @JoinTable(name="person_service",
    joinColumns = @JoinColumn(name = "id_person"),
    inverseJoinColumns = @JoinColumn(name="id_service"))
    List<Service> services;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_person")
    private List<Phone> phoneList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_person")
    private List<Video> videoList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_person")
    private List<Image> imageList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_person")
    private List<SocialNetwork> socialNetworkList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_person")
    private List<Review> reviewList;
}
