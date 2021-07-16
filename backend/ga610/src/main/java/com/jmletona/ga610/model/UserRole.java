package com.jmletona.ga610.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USER_ROLE")
@Data
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_role")
    private Integer roleId;

    @Column(name ="role_type")
    private String roleType;
}
