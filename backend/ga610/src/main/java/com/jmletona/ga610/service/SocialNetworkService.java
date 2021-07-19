package com.jmletona.ga610.service;

import com.jmletona.ga610.model.SocialNetwork;
import com.jmletona.ga610.repository.ISocialNetworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocialNetworkService implements ISocialNetworkService{
    @Autowired
    private ISocialNetworkRepository socialNetworkRepository;

    @Override
    public SocialNetwork create(SocialNetwork socialNetwork) {
        return socialNetworkRepository.save(socialNetwork);
    }

    @Override
    public SocialNetwork update(SocialNetwork socialNetwork) {
        SocialNetwork socialNetworkTMP = findById(socialNetwork.getIdSocialNetwork());
        socialNetworkTMP.setUrl(socialNetwork.getUrl());
        socialNetworkTMP.setType(socialNetwork.getType());
        return socialNetworkRepository.save(socialNetworkTMP);
    }

    @Override
    public SocialNetwork findById(Integer id) {
        Optional<SocialNetwork> socialNetworkOptional = socialNetworkRepository.findById(id);
        return socialNetworkOptional.orElse(null);
    }

    @Override
    public List<SocialNetwork> findAll() {
        return socialNetworkRepository.findAll();
    }

    @Override
    public List<String> findSocialNetworkTypes(){
        return socialNetworkRepository.findSocialNetworkTypes();
    }

    @Override
    public void delete(Integer id) {
        socialNetworkRepository.deleteById(id);
    }
}
