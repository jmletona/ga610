package com.jmletona.ga610.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_role")
@Data
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Integer roleId;

    @Column(name ="role_type")
    private String roleType;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="id_role")
    private List<CampusUser> users;
}
