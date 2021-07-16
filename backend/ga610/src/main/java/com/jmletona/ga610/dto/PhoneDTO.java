package com.jmletona.ga610.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PhoneDTO {
    private Integer idPhone;
    private Integer areaCode;
    private Integer number;
    private String phoneType;
    private Integer idPerson;
}
