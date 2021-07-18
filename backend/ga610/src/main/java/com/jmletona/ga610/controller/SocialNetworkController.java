package com.jmletona.ga610.controller;

import com.jmletona.ga610.dto.SocialNetworkDTO;
import com.jmletona.ga610.item.ItemSocialNetwork;
import com.jmletona.ga610.model.SocialNetwork;
import com.jmletona.ga610.responses.ResponseApi;
import com.jmletona.ga610.service.SocialNetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/socialNetworks")
public class SocialNetworkController {
    @Autowired
    private SocialNetworkService socialNetworkService;

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
        for(SocialNetwork socialNetwork : socialNetworkList)
            itemSocialNetworkList.add(showSocialNetwork(socialNetwork));
        return itemSocialNetworkList;
    }

    public ItemSocialNetwork showSocialNetwork(SocialNetwork socialNetwork){
        ItemSocialNetwork itemSocialNetwork = new ItemSocialNetwork();
        itemSocialNetwork.setIdSocialNetwork(socialNetwork.getIdSocialNetwork());
        itemSocialNetwork.setUrl(socialNetwork.getUrl());
        itemSocialNetwork.setType(socialNetwork.getType());
        return itemSocialNetwork;
    }

    @PostMapping
    public ResponseApi<ItemSocialNetwork> create(@RequestBody SocialNetworkDTO socialNetworkDTO){
        boolean success = false;
        String message = "Error";
        ItemSocialNetwork itemSocialNetwork = new ItemSocialNetwork();
        try {
            SocialNetwork socialNetwork = createSocialNetwork(socialNetworkDTO);
            if (socialNetwork != null){
                itemSocialNetwork = showSocialNetwork(socialNetwork);
                success = true;
                message = "SocialNetwork created successfully";
            }
        }catch (Exception ex){
            ex.printStackTrace();
            message = ex.getMessage();
        }
        return new ResponseApi<>(success, message, itemSocialNetwork);
    }

    public SocialNetwork createSocialNetwork(SocialNetworkDTO socialNetworkDTO){
        SocialNetwork socialNetwork = new SocialNetwork();
        socialNetwork.setUrl(socialNetworkDTO.getUrl());
        socialNetwork.setType(socialNetworkDTO.getType());
        //agregar persona
        return socialNetworkService.create(socialNetwork);
    }

    @PutMapping
    public ResponseApi<ItemSocialNetwork> update(@RequestBody SocialNetworkDTO socialNetworkDTO){
        boolean success = false;
        String message = "Error updating social Network";
        ItemSocialNetwork itemSocialNetwork = new ItemSocialNetwork();
        try {
            SocialNetwork socialNetwork = updateSocialNetwork(socialNetworkDTO);
            if (socialNetwork != null){
                itemSocialNetwork = showSocialNetwork(socialNetwork);
                success = true;
                message = "Social Network updated successfully";
            }
        }catch (Exception ex){
            ex.printStackTrace();
            message = ex.getMessage();
        }
        return new ResponseApi<>(success, message, itemSocialNetwork);
    }

    public SocialNetwork updateSocialNetwork(SocialNetworkDTO socialNetworkDTO){
        SocialNetwork socialNetwork = new SocialNetwork();
        socialNetwork.setUrl(socialNetworkDTO.getUrl());
        socialNetwork.setType(socialNetworkDTO.getType());
        //agregar persona
        return socialNetworkService.update(socialNetwork);
    }

    @GetMapping("/{id}")
    public ResponseApi<ItemSocialNetwork> findById(@PathVariable("id") Integer idSocialNetwork){
        boolean success = false;
        String message = "No social network found";
        ItemSocialNetwork itemSocialNetwork = new ItemSocialNetwork();
        SocialNetwork socialNetwork = socialNetworkService.findById(idSocialNetwork);
        if (socialNetwork != null){
            success = true;
            message = "Social Network found";
            itemSocialNetwork = showSocialNetwork(socialNetwork);
        }
        return new ResponseApi<>(success, message, itemSocialNetwork);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer idSocialNetwork){
        socialNetworkService.delete(idSocialNetwork);
    }
}
