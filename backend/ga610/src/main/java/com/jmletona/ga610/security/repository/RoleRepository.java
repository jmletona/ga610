package com.jmletona.ga610.security.repository;

import com.jmletona.ga610.security.entity.Role;
import com.jmletona.ga610.security.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(RoleName roleName);
}
