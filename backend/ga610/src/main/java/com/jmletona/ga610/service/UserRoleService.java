package com.jmletona.ga610.service;

import com.jmletona.ga610.model.Campus;
import com.jmletona.ga610.model.UserRole;
import com.jmletona.ga610.repository.IUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleService implements IUserRoleService {

    private IUserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleService(IUserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRole create(UserRole newUserRole) {
        return userRoleRepository.save(newUserRole);
    }

    @Override
    public UserRole update(UserRole userRoleToUpdate) {
        UserRole user = findById(userRoleToUpdate.getRoleId());
        user.setRoleType(userRoleToUpdate.getRoleType());
        //user.setUsers(userRoleToUpdate.getUsers());
        return userRoleRepository.save(user);
    }

    @Override
    public UserRole findById(Integer id) {
        Optional<UserRole> campusOptional = userRoleRepository.findById(id);
        return campusOptional.orElse(null);
    }

    @Override
    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        userRoleRepository.deleteById(id);
    }
}
