package com.jmletona.ga610.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPerson  implements  IItem{
    Integer idPerson;
    Boolean active;
    String company;
    String description;
    String name;
    String lastname;
    String address;
    String created;
    String campus;
}
