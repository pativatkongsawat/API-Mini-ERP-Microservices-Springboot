package com.example.erp.Auth.service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.erp.Auth.model.AuthRequest;
import com.example.erp.Auth.model.AuthResponse;
import com.example.erp.Auth.repository.AuthRepository;
import com.example.erp.Users.dto.CreateUser;
import com.example.erp.Users.model.User;
import com.example.erp.config.auth.AuthConfig;

@Service
public class AuthService {

    private final AuthRepository authRepository;
    private final AuthConfig jwtutils;
    private final PasswordEncoder passwordEncoder;

    public AuthService(AuthRepository authRepository, AuthConfig jwtutils, PasswordEncoder passwordEncoder) {

        this.authRepository = authRepository;
        this.jwtutils = jwtutils;
        this.passwordEncoder = passwordEncoder;

    }

    public AuthResponse Login(AuthRequest req) {

        User user = authRepository.findByEmail(req.getEmail()).orElseThrow(() ->

        new NoSuchElementException("Email or Password Invalid")

        );

        if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
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

    public User Register(CreateUser data) {

        boolean allFildHaveData = data.getEmail() != null && !data.getEmail().isBlank() &&
                data.getFname() != null && !data.getFname().isBlank() &&
                data.getLname() != null && !data.getLname().isBlank() &&
                data.getPassword() != null && !data.getPassword().isBlank() &&
                data.getDepartmentId() != null && data.getRoleId() != null &&
                data.getSalary() != null && data.getUserId() != null &&
                !data.getUserId().isBlank() && data.getUsername() != null &&
                !data.getUsername().isBlank();

        if (!allFildHaveData) {
            throw new NoSuchElementException("All fields must have data");
        }

        String hashpassword = passwordEncoder.encode(data.getPassword());

        User user = new User();

        LocalDateTime now = LocalDateTime.now();

        user.setUserId(data.getUserId());
        user.setUsername(data.getUsername());
        user.setEmail(data.getEmail());
        user.setPassword(hashpassword);
        user.setFname(data.getFname());
        user.setLname(data.getLname());
        user.setDepartmentId(data.getDepartmentId());
        user.setRoleId(data.getRoleId());
        user.setSalary(data.getSalary());
        user.setIsActive(true);

        user.setHireDate(now);
        user.setCreatedAt(now);
        user.setUpdatedAt(now);

        return user;
    }

}
