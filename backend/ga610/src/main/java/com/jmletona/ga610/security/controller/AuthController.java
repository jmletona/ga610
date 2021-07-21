package com.jmletona.ga610.security.controller;

import com.jmletona.ga610.dto.Message;
import com.jmletona.ga610.security.dto.JwtDTO;
import com.jmletona.ga610.security.dto.NewUser;
import com.jmletona.ga610.security.dto.UserLogin;
import com.jmletona.ga610.security.entity.Role;
import com.jmletona.ga610.security.entity.User;
import com.jmletona.ga610.security.enums.RoleName;
import com.jmletona.ga610.security.jwt.JwtProvider;
import com.jmletona.ga610.security.service.RoleService;
import com.jmletona.ga610.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/new")
    public ResponseEntity<?> newUser(@Valid @RequestBody NewUser newUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity( new Message("Invalid credentials"), HttpStatus.BAD_REQUEST);
        if(userService.existsByUser(newUser.getUser()))
            return new ResponseEntity(new Message("Name existed"), HttpStatus.BAD_REQUEST);
        if(userService.existsByEmail(newUser.getEmail()))
            return new ResponseEntity(new Message("Email existed"), HttpStatus.BAD_REQUEST);

        User user = new User(newUser.getName(), newUser.getUser(),newUser.getEmail(), passwordEncoder.encode(newUser.getPassword()));

        Set<Role> roles = new HashSet<>();

        roles.add(roleService.getByRoleName(RoleName.END_USER).get());
        if(newUser.getRoles().contains("ADMIN"))
            roles.add(roleService.getByRoleName(RoleName.ADMIN).get());
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity(new Message("User created"), HttpStatus.CREATED);


    }

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody UserLogin userLogin, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Message("Invalid credentials"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUser(), userLogin.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        JwtDTO jwtDTO = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDTO, HttpStatus.OK);
    }
}
