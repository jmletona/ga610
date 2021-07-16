package com.jmletona.ga610.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="service")
@Data
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_service")
    private Integer serviceId;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "created")
    private LocalDate createdAt;
}
