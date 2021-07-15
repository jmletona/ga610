package com.jmletona.ga610.model;

import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="PERSON")
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_person")
    private Integer idPerson;

    @Column(name ="active")
    private Boolean active;

    @Column(name ="company")
    private String company;

    @Column(name ="description")
    private String description;

    @Column(name ="name")
    private String name;

    @Column(name ="lastname")
    private String lastname;

    @Column(name ="address")
    private String address;

    @Column(name ="created")
    private Date created;

    @ManyToOne
    @JoinColumn(name = "id_campus")
    private Campus campus;
}
