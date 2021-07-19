package com.jmletona.ga610.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "campus_user")
@Data
public class CampusUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private Integer userId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "user_password")
    private String userPassword;
    
    @Column(name = "created")
    private LocalDate createdAt;

    @ManyToOne
   // @JoinColumn(name = "id_role")
    private UserRole userRole;

    @Column(name = "id_role")
    private Integer roleId;

    @ManyToOne
    private Campus campus;

    @Column(name = "id_campus")
    private Integer campusId;

}
