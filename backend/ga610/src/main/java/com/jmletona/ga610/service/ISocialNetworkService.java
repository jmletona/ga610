package com.jmletona.ga610.service;

import com.jmletona.ga610.model.SocialNetwork;

import java.util.List;

public interface ISocialNetworkService {

    SocialNetwork create(SocialNetwork socialNetwork);

    SocialNetwork update(SocialNetwork socialNetwork);

    SocialNetwork findById(Integer id);

    List<SocialNetwork> findAll();

    List<String> findSocialNetworkTypes();

    void delete(Integer id);
}
