package com.jmletona.ga610.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;

@Getter
@Setter
public class ServiceDTO {

    private Integer serviceId;

    private String serviceName;

    private LocalDate createdAt;
}
