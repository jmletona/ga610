package com.jmletona.ga610.security.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "campus_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int id;

    //@NotNull
    @Column(name = "full_name")
    private String name;

    //@NotNull
    @Column(unique = true, name = "user")
    private String user;

    //@NotNull
    @Column(name = "email")
    private String email;

    //@NotNull
    @Column(name = "user_password")
    private String password;

    public User() {
    }

    public User(String name, String user, String email, String password) {
        this.name = name;
        this.user = user;
        this.email = email;
        this.password = password;
    }

    //@NotNull
    @ManyToOne
    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "id_user"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
}
