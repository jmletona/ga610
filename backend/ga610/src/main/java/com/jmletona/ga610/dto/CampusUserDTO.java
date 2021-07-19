package com.jmletona.ga610.dto;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;
@Data
public class CampusUserDTO {
    private Integer userId;
    private Integer campusId;
    private String fullName;
    private String email;
    private String userPassword;
    private LocalDate createdAt;
}
