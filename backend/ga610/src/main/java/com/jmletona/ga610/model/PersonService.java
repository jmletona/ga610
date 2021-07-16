package com.jmletona.ga610.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON_SERVICE")
@Data
public class PersonService {

    @Id
    @Column(name = "id_person")
    private Integer personId;

    @Id
    @Column(name="id_service")
    private Integer serviceId;
}
