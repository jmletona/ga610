package com.jmletona.ga610.dto;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
public class ServiceDTO {

    private Integer serviceId;

    private String serviceName;

    private LocalDate createdAt;
}
