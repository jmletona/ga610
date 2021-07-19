package com.jmletona.ga610.controller;

import com.jmletona.ga610.dto.SocialNetworkDTO;
import com.jmletona.ga610.item.ItemSocialNetwork;
import com.jmletona.ga610.model.SocialNetwork;
import com.jmletona.ga610.responses.ResponseApi;
import com.jmletona.ga610.service.SocialNetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/socialnetworks")
public class SocialNetworkController {

    @Autowired
    private SocialNetworkService socialNetworkService;

    @GetMapping
    public ResponseApi<List<ItemSocialNetwork>> getAllSocialNetworks(){
        boolean success = false;
        String message = "No Social Network found";
        List<ItemSocialNetwork> itemSocialNetworkList = new ArrayList<>();
        List<SocialNetwork> socialNetworkList = socialNetworkService.findAll();
        if(!socialNetworkList.isEmpty()){
            success = true;
            message = "SocialNetwork found";
            itemSocialNetworkList = showAllSocialNetworks(socialNetworkList, itemSocialNetworkList);
        }
        return new ResponseApi<>(success, message, itemSocialNetworkList);
    }

    public List<ItemSocialNetwork> showAllSocialNetworks(List<SocialNetwork> socialNetworkList, List<ItemSocialNetwork> itemSocialNetworkList){
        for(SocialNetwork socialNetwork : socialNetworkList){
            ItemSocialNetwork itemSocialNetwork = new ItemSocialNetwork();
            itemSocialNetworkList.add(showSocialNetwork(socialNetwork, itemSocialNetwork));
        }
        return itemSocialNetworkList;
    }

    public ItemSocialNetwork showSocialNetwork(SocialNetwork socialNetwork, ItemSocialNetwork itemSocialNetwork){
        itemSocialNetwork.setIdSocialNetwork(socialNetwork.getIdSocialNetwork());
        itemSocialNetwork.setUrl(socialNetwork.getUrl());
        itemSocialNetwork.setType(socialNetwork.getType());
        itemSocialNetwork.setIdPerson(socialNetwork.getIdPerson().toString());
        itemSocialNetwork.setCreated(socialNetwork.getCreated().toString());
        return itemSocialNetwork;
    }

    @PostMapping
    public ResponseApi<ItemSocialNetwork> create(@RequestBody SocialNetworkDTO socialNetworkDTO){
        boolean success = false;
        String message = "Error";
        ItemSocialNetwork itemSocialNetwork = new ItemSocialNetwork();
        SocialNetwork socialNetwork = new SocialNetwork();
        try {
            socialNetwork = createSocialNetwork(socialNetwork, socialNetworkDTO);
            if (socialNetwork != null){
                itemSocialNetwork = showSocialNetwork(socialNetwork, itemSocialNetwork);
                success = true;
                message = "SocialNetwork created successfully";
            }
        }catch (Exception ex){
            ex.printStackTrace();
            message = ex.getMessage();
        }
        return new ResponseApi<>(success, message, itemSocialNetwork);
    }

    public SocialNetwork createSocialNetwork(SocialNetwork socialNetwork, SocialNetworkDTO socialNetworkDTO){
        socialNetwork.setUrl(socialNetworkDTO.getUrl());
        socialNetwork.setType(socialNetworkDTO.getType());
        socialNetwork.setIdPerson(socialNetworkDTO.getIdPerson());
        socialNetwork.setCreated(Timestamp.valueOf(LocalDateTime.now()));
        return socialNetworkService.create(socialNetwork);
    }

    @PutMapping
    public ResponseApi<ItemSocialNetwork> update(@RequestBody SocialNetworkDTO socialNetworkDTO){
        boolean success = false;
        String message = "Error updating social Network";
        SocialNetwork socialNetwork = new SocialNetwork();
        ItemSocialNetwork itemSocialNetwork = new ItemSocialNetwork();
        try {
            socialNetwork = updateSocialNetwork(socialNetwork, socialNetworkDTO);
            if (socialNetwork != null){
                itemSocialNetwork = showSocialNetwork(socialNetwork, itemSocialNetwork);
                success = true;
                message = "Social Network updated successfully";
            }
        }catch (Exception ex){
            ex.printStackTrace();
            message = ex.getMessage();
        }
        return new ResponseApi<>(success, message, itemSocialNetwork);
    }

    public SocialNetwork updateSocialNetwork(SocialNetwork socialNetwork, SocialNetworkDTO socialNetworkDTO){
        socialNetwork.setIdSocialNetwork(socialNetworkDTO.getIdSocialNetwork());
        socialNetwork.setUrl(socialNetworkDTO.getUrl());
        socialNetwork.setType(socialNetworkDTO.getType());
        return socialNetworkService.update(socialNetwork);
    }

    @GetMapping("/{id}")
    public ResponseApi<ItemSocialNetwork> findById(@PathVariable("id") Integer idSocialNetwork){
        boolean success = false;
        String message = "No social network found";
        ItemSocialNetwork itemSocialNetwork = new ItemSocialNetwork();
        List<ItemSocialNetwork> itemSocialNetworkList = new ArrayList<>();
        SocialNetwork socialNetwork = socialNetworkService.findById(idSocialNetwork);
        if (socialNetwork != null){
            success = true;
            message = "Social Network found";
            itemSocialNetwork = showSocialNetwork(socialNetwork, itemSocialNetwork);
        }
        return new ResponseApi<>(success, message, itemSocialNetwork);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer idSocialNetwork){
        socialNetworkService.delete(idSocialNetwork);
    }
}
