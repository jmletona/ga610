package com.jmletona.ga610.security.repository;

import com.jmletona.ga610.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import java.util.Optional;

@Entity
public interface UserRepository  extends JpaRepository<User, Integer> {
    Optional<User> findByUser(String user);
    boolean existsByUser(String user);
    boolean existsByEmail(String email);


}
