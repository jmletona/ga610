package com.jmletona.ga610.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "phone")
@Getter
@Setter
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_phone")
    private Integer idPhone;

    @Column(name = "area_code")
    private Integer areaCode;

    @Column(name = "phone_number")
    private Integer number;

    @Column(name = "phone_type", columnDefinition = "enum('OFFICE','CELLPHONE','WHATSAPP', 'LOCALPHONE')")
    private String type;

    @Column(name = "id_person")
    private Integer idPerson;

    @Column(name = "created")
    private Date created;
}
