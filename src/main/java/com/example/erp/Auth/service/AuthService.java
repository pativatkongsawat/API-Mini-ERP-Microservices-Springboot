package com.example.erp.Auth.service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.erp.Auth.model.AuthRequest;
import com.example.erp.Auth.model.AuthResponse;
import com.example.erp.Auth.repository.AuthRepository;
import com.example.erp.Users.dto.CreateUser;
import com.example.erp.Users.model.User;
import com.example.erp.config.auth.AuthConfig;

public class AuthService {

    private final AuthRepository authRepository;
    private final AuthConfig jwtutils;
    private final PasswordEncoder passwordEncoder;

    public AuthService(AuthRepository authRepository , AuthConfig jwtutils , PasswordEncoder passwordEncoder) {

        this.authRepository = authRepository;
        this.jwtutils = jwtutils;
        this.passwordEncoder = passwordEncoder;

    }

    public AuthResponse Login(AuthRequest req){

        User user = authRepository.findbyEmail(req.getEmail()).orElseThrow(() -> 

            new NoSuchElementException("Email Not Found")

        );

        if(!user.getPassword().equals(req.getPassword())){

            throw new NoSuchElementException("Email or Password Invalid");

        }

        String token = jwtutils.generateToken(user);

        AuthResponse res = new AuthResponse();

        res.setToken(token);
        res.setUserID(user.getUserId());
        res.setEmail(user.getEmail());
        res.setDepartmentId(user.getDepartmentId());
        res.setRoleID(user.getRoleId());

        res.setFirstName(user.getFname());
        res.setLastName(user.getLname());
        

        return res;

    }

    public User Register(CreateUser data){
        
        User user = new User();

        LocalDateTime now = LocalDateTime.now();



        return user;
    }

}
