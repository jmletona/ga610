package com.jmletona.ga610.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PersonDTO {
    private Integer idPerson;
    private Boolean active;
    private String company;
    private String description;
    private String name;
    private String lastname;
    private String address;
    private Date created;
}
