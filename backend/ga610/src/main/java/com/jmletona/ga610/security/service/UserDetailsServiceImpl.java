package com.jmletona.ga610.security.service;

import com.jmletona.ga610.security.entity.MainUser;
import com.jmletona.ga610.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;


    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        User userLoaded = userService.getByUser(user).get();
        return MainUser.build(userLoaded);
    }
}
