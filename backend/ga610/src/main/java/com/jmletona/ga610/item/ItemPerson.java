package com.jmletona.ga610.item;

import com.jmletona.ga610.model.Image;
import com.jmletona.ga610.model.Phone;
import com.jmletona.ga610.model.SocialNetwork;
import com.jmletona.ga610.model.Video;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemPerson implements IItem{
    Integer idPerson;
    Boolean active;
    String company;
    String description;
    String name;
    String lastname;
    String address;
    String created;
    String idCampus;
    List<SocialNetwork> socialNetworks;
    List<Video> videos;
    List<Phone> phones;
    List<Image> gallery;
}
