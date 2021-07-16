package com.jmletona.ga610.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CAMPUS_USER")
@Data
public class CampusUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private Integer userId;

    @Column(name = "id_campus")
    private Integer campusId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "id_role")
    private Integer roleId;

    @Column(name = "created")
    private LocalDate createdAt;

}
