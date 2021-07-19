package com.jmletona.ga610.item;

import com.jmletona.ga610.model.Phone;
import com.jmletona.ga610.model.Review;
import com.jmletona.ga610.model.SocialNetwork;
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
    List<SocialNetwork> socialNetworks;
    List<Video> videos;
    List<Phone> phones;
    List<String> gallery;
    List<Review> reviews;
}
