package com.jmletona.ga610.item;

import com.jmletona.ga610.model.Video;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemPublicPerson implements IItem{
    Integer idPerson;
    Boolean active;
    String company;
    String description;
    String name;
    String lastname;
    String address;
    String created;
    String campus;
    List<Video> videos;
    List<String> gallery;
}
