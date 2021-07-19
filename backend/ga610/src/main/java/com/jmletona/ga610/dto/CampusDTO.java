package com.jmletona.ga610.dto;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;
@Data
public class CampusDTO {

    private Integer campusId;
    private String name;
    private String country;
    private LocalDate createdAt;
}
