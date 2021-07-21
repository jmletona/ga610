package com.jmletona.ga610.security.entity;

import com.jmletona.ga610.security.enums.RoleName;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Role() {
    }

    public Role(RoleName roleName) {
        this.roleName = roleName;
    }

    public Role(int id, RoleName roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleName roleName;
}
