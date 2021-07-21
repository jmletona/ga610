package com.jmletona.ga610.security.service;

import com.jmletona.ga610.security.entity.User;
import com.jmletona.ga610.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<User> getByUser(String user){
        return userRepository.findByUser(user);
    }

    public boolean existsByUser(String user){
        return userRepository.existsByUser(user);
    }
    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public void save(User user){
        userRepository.save(user);
    }
}

