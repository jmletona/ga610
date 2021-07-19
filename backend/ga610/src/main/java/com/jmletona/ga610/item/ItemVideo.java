package com.jmletona.ga610.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemVideo implements IItem{
    private Integer idVideo;
    private String url;
    private String idPerson;
    private String created;
}
