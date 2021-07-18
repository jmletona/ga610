package com.jmletona.ga610.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "campus")
@Data
public class Campus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_campus")
    private Integer campusId;

    @Column(name ="campus_name")
    private String name;

    @Column(name ="created")
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name="country_id", referencedColumnName="id")
    private Country country;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="id_user")
    private List<CampusUser> campusUserList;

}
