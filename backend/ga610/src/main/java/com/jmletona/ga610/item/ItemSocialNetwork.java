package com.jmletona.ga610.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemSocialNetwork implements IItem{
    Integer idSocialNetwork;
    String url;
    String type;
    String person;
    String created;
}
