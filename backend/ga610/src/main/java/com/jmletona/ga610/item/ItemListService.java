package com.jmletona.ga610.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemListService implements IItem{
    Integer idPerson;
    String company;
    String name;
    String lastname;
    String ranking;
}
