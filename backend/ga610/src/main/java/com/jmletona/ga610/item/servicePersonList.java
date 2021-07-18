package com.jmletona.ga610.item;

import com.jmletona.ga610.model.Service;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class servicePersonList implements  IItem{
    private Integer idPerson;
    private String name;
    private String lastname;
    private String company;
    private Integer ranking;
    private String Service;
    
}
