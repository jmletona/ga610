package com.jmletona.ga610.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemImage implements  IItem{
    private Integer idImage;
    private String urlImage;
    private String idPerson;
    private String updated;
}
