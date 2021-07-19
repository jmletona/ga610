package com.jmletona.ga610.item;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ItemCampusUser {
    private Integer userId;
    private Integer campusId;
    private Integer roleId;
    private String fullName;
    private String email;
    private String userPassword;
    private String createdAt;
}
