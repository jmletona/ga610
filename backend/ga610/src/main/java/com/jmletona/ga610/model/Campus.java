package com.jmletona.ga610.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "campus")
@Data
public class Campus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_campus")
    private Integer campusId;

    @Column(name = "campus_name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "created")
    private Timestamp createdAt;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_campus")
    private List<Person> personList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_campus")
    private List<CampusUser> campusUserList;


}
