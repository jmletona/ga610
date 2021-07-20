package com.jmletona.ga610.controller;

import com.jmletona.ga610.dto.UserRoleDTO;
import com.jmletona.ga610.dto.VideoDTO;
import com.jmletona.ga610.item.ItemUserRole;
import com.jmletona.ga610.item.ItemVideo;
import com.jmletona.ga610.model.UserRole;
import com.jmletona.ga610.model.Video;
import com.jmletona.ga610.responses.ResponseApi;
import com.jmletona.ga610.service.UserRoleService;
import com.jmletona.ga610.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/userrol")
public class UserRolController {

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping
    public ResponseApi<List<ItemUserRole>> getAllUsersRol() {
        boolean success = false;
        String message = "No UserRol found";
        List<ItemUserRole> itemUserRoles = new ArrayList<>();
        List<UserRole> usersRolList = userRoleService.findAll();
        if (!usersRolList.isEmpty()) {
            success = true;
            message = "Roles found";
            itemUserRoles = showAllUserRol(usersRolList, itemUserRoles);
        }
        return new ResponseApi<>(success, message, itemUserRoles);
    }

    public List<ItemUserRole> showAllUserRol(List<UserRole> userRoleList, List<ItemUserRole> itemUserRoleList) {
        for (UserRole userRole : userRoleList) {
            ItemUserRole itemUserRole = new ItemUserRole();
            itemUserRoleList.add(showUserRole(userRole, itemUserRole));
        }
        return itemUserRoleList;
    }

    public ItemUserRole showUserRole(UserRole userRole, ItemUserRole itemUserRole) {
        itemUserRole.setRoleId(userRole.getRoleId());
        itemUserRole.setRoleType(userRole.getRoleType());

        return itemUserRole;
    }

    @PostMapping
    public ResponseApi<ItemUserRole> create(@RequestBody UserRoleDTO userRoleDTO) {

        boolean success = false;
        String message = "Error";
        UserRole userRole = new UserRole();
        ItemUserRole itemUserRole = new ItemUserRole();
        try {
            userRole = createUserRole(userRole, userRoleDTO);
            if (userRole != null) {
                itemUserRole = showUserRole(userRole, itemUserRole);

                success = true;
                message = "UserRolo created successfully";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            message = ex.getMessage();
        }
        return new ResponseApi<>(success, message, itemUserRole);
    }

    public UserRole createUserRole(UserRole userRole, UserRoleDTO userRoleDTO) {
        userRole.setRoleType(userRoleDTO.getRoleType());

        return userRoleService.create(userRole);
    }

    @PutMapping
    public ResponseApi<ItemUserRole> update(@RequestBody UserRoleDTO userRoleDTO) {
        boolean success = false;
        String message = "Error updating UserRole";
        UserRole userRole = new UserRole();
        ItemUserRole itemUserRole = new ItemUserRole();
        try {
            userRole = updateUserRole(userRole, userRoleDTO);
            if (userRole != null) {
                itemUserRole = showUserRole(userRole, itemUserRole);
                success = true;
                message = "UserRole updated successfully";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            message = ex.getMessage();
        }
        return new ResponseApi<>(success, message, itemUserRole);
    }

    public UserRole updateUserRole(UserRole userRole, UserRoleDTO userRoleDTO) {
        userRole.setRoleType(userRoleDTO.getRoleType());
        userRole.setRoleId(userRoleDTO.getRoleId());
        return userRoleService.update(userRole);
    }

    @GetMapping("/{id}")
    public ResponseApi<ItemUserRole> findById(@PathVariable("id") Integer idUserRol) {
        boolean success = false;
        String message = "No User role found";
        ItemUserRole itemUserRole = new ItemUserRole();
        UserRole userRole = userRoleService.findById(idUserRol);
        if (userRole != null) {
            success = true;
            message = "Video was found";
            itemUserRole = showUserRole(userRole, itemUserRole);
        }
        return new ResponseApi<>(success, message, itemUserRole);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer idUserRole) {
        userRoleService.delete(idUserRole);
    }
}
