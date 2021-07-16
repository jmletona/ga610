package com.jmletona.ga610.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
<<<<<<< HEAD
import java.util.Set;


@Entity
@Table(name = "person")
=======


@Entity
@Table(name="person")
>>>>>>> letona
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private Integer idPerson;
<<<<<<< HEAD
    @Column(name = "active")
=======

    @Column(name ="is_active")
>>>>>>> letona
    private Boolean active;
    @Column(name = "company")
    private String company;
<<<<<<< HEAD
    @Column(name = "description")
    private String description;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
=======

    @Column(name ="person_description")
    private String description;

    @Column(name ="person_name")
    private String name;

    @Column(name ="person_lastname")
>>>>>>> letona
    private String lastname;
    @Column(name = "address")
    private String address;
    @Column(name = "created")
    private Date created;
<<<<<<< HEAD
    /*@Column(name = "id_campus")
    private Campus campus;*/
=======

    /*@ManyToOne
    @JoinTable(name="person_service",
    joinColumns = @JoinColumn(name = "id_person"),
    inverseJoinColumns = @JoinColumn(name="id_service"))
    List<Service> services;
>>>>>>> letona

    @ManyToOne
    @JoinColumn(name = "id_campus")
    private Campus campus;

    */


}
