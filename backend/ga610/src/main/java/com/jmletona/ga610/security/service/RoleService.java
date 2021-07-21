package com.jmletona.ga610.security.service;

import com.jmletona.ga610.security.entity.Role;
import com.jmletona.ga610.security.enums.RoleName;
import com.jmletona.ga610.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Optional<Role> getByRoleName(RoleName roleName){
        return roleRepository.findByRoleName(roleName);
    }
}
