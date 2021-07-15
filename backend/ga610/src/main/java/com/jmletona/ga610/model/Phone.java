package com.jmletona.ga610.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PHONE")
@Getter
@Setter
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_phone")
    private int idPhone;

    @Column(name = "area_code")
    private int areaCode;

    @Column(name = "phone_number")
    private int number;

    @Column(name = "phone_type", columnDefinition = "enum('OFFICE','CELLPHONE','WHATSAPP')")
    private String type;

     /*
     private Person person;
      */

    @Column(name = "created")
    private Date created;
}
