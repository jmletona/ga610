package com.jmletona.ga610.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "campus_user")
@Data
public class CampusUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer userId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "created")
    private Timestamp createdAt;

    @Column(name = "id_role")
    private Integer idRole;

    @Column(name = "id_campus")
    private Integer idCampus;

}
