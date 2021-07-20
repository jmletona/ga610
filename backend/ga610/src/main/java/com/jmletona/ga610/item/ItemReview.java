package com.jmletona.ga610.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemReview implements IItem{
    Integer idReview;
    String ranking;
    String status;
    String comment;
    String person;
    String user;
    String created;
}
