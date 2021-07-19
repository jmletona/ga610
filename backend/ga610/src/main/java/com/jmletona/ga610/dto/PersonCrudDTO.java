package com.jmletona.ga610.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonCrudDTO {

    private PersonDTO person;
    private List<VideoDTO> videos;
    private List<PhoneDTO> phones;
    private List<SocialNetworkDTO> socialNetworks;
    private List<ServiceDTO> services;

}
