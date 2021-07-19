package com.jmletona.ga610.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemSocialNetwork implements IItem{
    private Integer idSocialNetwork;
    private String url;
    private String type;
    private String idPerson;
    private String created;
}
