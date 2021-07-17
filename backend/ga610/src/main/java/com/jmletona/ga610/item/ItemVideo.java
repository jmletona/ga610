package com.jmletona.ga610.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemVideo implements IItem{
    Integer idVideo;
    String url;
    String idPerson;
    String created;
}
