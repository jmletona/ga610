package com.jmletona.ga610.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person_service")
@IdClass(PersonServiceId.class)
@Getter
@Setter
public class PersonService implements Serializable {
    @Id
    @Column(name = "id_person")
    private Integer idPerson;

    @Id
    @Column(name = "id_service")
    private Integer idService;
}
