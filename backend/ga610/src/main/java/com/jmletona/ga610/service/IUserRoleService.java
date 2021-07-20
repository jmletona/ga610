package com.jmletona.ga610.service;

import com.jmletona.ga610.model.Campus;
import com.jmletona.ga610.model.UserRole;

import java.util.List;

public interface IUserRoleService {
    UserRole create(UserRole newUserRole);

    UserRole update(UserRole userRoleToUpdate);

    UserRole findById(Integer id);

    List<UserRole> findAll();

    void delete(Integer id);
}
