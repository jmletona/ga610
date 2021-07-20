package com.jmletona.ga610.controller;

import com.jmletona.ga610.dto.CampusUserDTO;
import com.jmletona.ga610.item.ItemCampusUser;
import com.jmletona.ga610.model.CampusUser;
import com.jmletona.ga610.responses.ResponseApi;
import com.jmletona.ga610.service.CampusUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class CampusUserController {

    @Autowired
    private CampusUserService campusUserService;

    @GetMapping
    public ResponseApi<List<ItemCampusUser>> getAllUsers() {
        boolean success = false;
        String message = "No user found";
        List<ItemCampusUser> itemCampusUserList = new ArrayList<>();
        List<CampusUser> usersList = campusUserService.findAll();
        if (!usersList.isEmpty()) {
            success = true;
            message = "User found";
            itemCampusUserList = showAllUsers(usersList, itemCampusUserList);
        }
        return new ResponseApi<>(success, message, itemCampusUserList);
    }

    public List<ItemCampusUser> showAllUsers(List<CampusUser> campusUserList,
                                             List<ItemCampusUser> itemCampusUserList) {
        for (CampusUser user : campusUserList) {
            ItemCampusUser itemCampusUser = new ItemCampusUser();
            itemCampusUser = showUser(user, itemCampusUser);
            itemCampusUserList.add(itemCampusUser);
        }
        return itemCampusUserList;
    }

    public ItemCampusUser showUser(CampusUser campusUser, ItemCampusUser itemCampusUser) {
        itemCampusUser.setIdUser(campusUser.getUserId());
        itemCampusUser.setFullName(campusUser.getFullName());
        itemCampusUser.setEmail(campusUser.getEmail());
        itemCampusUser.setUserPassword(campusUser.getUserPassword());
        itemCampusUser.setCreatedAt(campusUser.getCreatedAt().toString());
        itemCampusUser.setIdCampus(campusUser.getIdCampus());
        itemCampusUser.setIdRole(campusUser.getIdRole());
        return itemCampusUser;
    }

    @PostMapping
    public ResponseApi<ItemCampusUser> create(@RequestBody CampusUserDTO campusUserDTO) {
        boolean success = false;
        String message = "Error";
        CampusUser campusUser = new CampusUser();
        ItemCampusUser itemCampusUser = new ItemCampusUser();
        try {
            campusUser = createUser(campusUser, campusUserDTO);
            if (campusUser != null) {
                itemCampusUser = showUser(campusUser, itemCampusUser);
                success = true;
                message = "User was created successfully";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            message = ex.getMessage();
        }
        return new ResponseApi<>(success, message, itemCampusUser);
    }

    public CampusUser createUser(CampusUser campusUser, CampusUserDTO campusUserDTO) {
        campusUser.setFullName(campusUserDTO.getFullName());
        campusUser.setEmail(campusUserDTO.getEmail());
        campusUser.setUserPassword(campusUserDTO.getUserPassword());
        campusUser.setIdCampus(campusUserDTO.getIdCampus());
        campusUser.setIdRole(campusUserDTO.getIdRole());
        campusUser.setCreatedAt(Timestamp.from(Instant.now()));
        campusUser = this.campusUserService.create(campusUser);
        return campusUser;
    }

    @PutMapping
    public ResponseApi<ItemCampusUser> update(@RequestBody CampusUserDTO campusUserDTO) {
        boolean success = false;
        String message = "Error updating User";
        CampusUser campusUser = new CampusUser();
        ItemCampusUser itemCampusUser = new ItemCampusUser();
        try {
            campusUser = updateUser(campusUser, campusUserDTO);
            if (campusUser != null) {
                itemCampusUser = showUser(campusUser, itemCampusUser);
                success = true;
                message = "User was updated successfully";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            message = ex.getMessage();
        }
        return new ResponseApi<>(success, message, itemCampusUser);
    }

    public CampusUser updateUser(CampusUser campusUser, CampusUserDTO campusUserDTO) {
        campusUser.setUserId(campusUserDTO.getIdUser());
        campusUser.setFullName(campusUserDTO.getFullName());
        campusUser.setEmail(campusUserDTO.getEmail());
        campusUser.setUserPassword(campusUserDTO.getUserPassword());
        campusUser.setIdCampus(campusUserDTO.getIdCampus());
        campusUser.setIdRole(campusUserDTO.getIdRole());
        campusUser.setCreatedAt(Timestamp.from(Instant.now()));
        campusUser = this.campusUserService.update(campusUser);
        return campusUser;
    }

    @GetMapping("/{id}")
    public ResponseApi<ItemCampusUser> findById(@PathVariable("id") Integer userId) {
        boolean success = false;
        String message = "No User found";
        ItemCampusUser itemCampusUser = new ItemCampusUser();
        CampusUser user = campusUserService.findById(userId);
        if (user != null) {
            itemCampusUser = showUser(user, itemCampusUser);
            success = true;
            message = "User found";
        }
        return new ResponseApi<>(success, message, itemCampusUser);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer userId) {
        campusUserService.delete(userId);
    }
}
