package com.jmletona.ga610.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PersonServiceId implements Serializable {
    private Integer idPerson;
    private Integer idService;
}
