package com.jmletona.ga610.item;

import lombok.Data;

@Data
public class ItemCampusUser {
    private Integer idUser;
    private String fullName;
    private String email;
    private String userPassword;
    private Integer idCampus;
    private Integer idRole;
    private String createdAt;
}
