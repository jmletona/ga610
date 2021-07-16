package com.jmletona.ga610.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "service")
@Data
public class Service {

    // ManyToMay relationship between Person and service.
    @ManyToMany(mappedBy = "services")
    List<Person> persons;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_service")
    private Integer serviceId;
    @Column(name = "service_name")
    private String serviceName;
    @Column(name = "created")
    private LocalDate createdAt;
}
