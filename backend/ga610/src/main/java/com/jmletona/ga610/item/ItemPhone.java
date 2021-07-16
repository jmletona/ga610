package com.jmletona.ga610.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPhone implements IItem {
    Integer idPhone;
    String areaCode;
    String number;
    String type;
    String updated;
    Integer idPerson;
}
