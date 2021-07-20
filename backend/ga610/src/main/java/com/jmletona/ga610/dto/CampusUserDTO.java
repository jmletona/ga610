package com.jmletona.ga610.dto;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class CampusUserDTO {
    private Integer idUser;
    private Integer idCampus;
    private String fullName;
    private String email;
    private String userPassword;
    private Timestamp createdAt;
    private Integer idRole;
}
