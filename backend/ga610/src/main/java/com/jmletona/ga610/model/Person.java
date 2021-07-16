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

    @Column(name ="company")
    private String company;

    @Column(name ="person_description")
    private String description;

    @Column(name ="person_name")
    private String name;

    @Column(name ="person_lastname")
    private String lastname;

    @Column(name ="address")
    private String address;

    @Column(name ="created")
    private Date created;

    /*@ManyToOne
    @JoinTable(name="person_service",
    joinColumns = @JoinColumn(name = "id_person"),
    inverseJoinColumns = @JoinColumn(name="id_service"))
    List<Service> services;

    @ManyToOne
    @JoinColumn(name = "id_campus")
    private Campus campus;

    */


}
