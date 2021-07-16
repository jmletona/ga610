package com.jmletona.ga610.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="person")
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    /*@Column(name = "id_campus")
    private Campus campus;*/

   /* @ManyToOne
    @JoinColumn(name = "id_campus")
    private Campus campus;*/
}
