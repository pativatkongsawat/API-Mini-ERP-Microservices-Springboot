package com.example.erp.Users.services;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.erp.Users.dto.CreateUser;
import com.example.erp.Users.model.User;
import com.example.erp.Users.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> getById(Integer id) {
        return userRepository.findById(id);
    }

    public User CreateNewUser(CreateUser user) {

        LocalDateTime now = LocalDateTime.now();

        User data = new User();

        String hashpassword = passwordEncoder.encode(user.getPassword());

        data.setUserId(user.getUserId());
        data.setUsername(user.getUsername());
        data.setEmail(user.getEmail());
        data.setPassword(hashpassword);
        data.setFname(user.getFname());
        data.setLname(user.getLname());
        data.setDepartmentId(user.getDepartmentId());
        data.setRoleId(user.getRoleId());
        data.setSalary(user.getSalary());

        data.setHireDate(now);
        data.setIsActive(true);
        data.setCreatedAt(now);
        data.setUpdatedAt(now);

        return userRepository.save(data);

    }

    public Optional<User> UpdateUser(CreateUser user, Integer id) {

        boolean isAllFieldNullOrBlank = (user.getEmail() == null || user.getEmail().isBlank()) &&
                (user.getFname() == null || user.getFname().isBlank()) &&
                (user.getLname() == null || user.getLname().isBlank()) &&
                (user.getPassword() == null || user.getPassword().isBlank()) &&
                (user.getUsername() == null || user.getUsername().isBlank()) &&
                user.getRoleId() == null &&
                user.getDepartmentId() == null &&
                user.getSalary() == null;

        if (isAllFieldNullOrBlank) {
            throw new IllegalArgumentException("Add at least 1 field to update");
        }

        LocalDateTime now = LocalDateTime.now();

        return userRepository.findById(id).map(data ->{

            if (user.getEmail() != null && !user.getEmail().isBlank()) {
                data.setEmail(user.getEmail());
            }
            if (user.getFname() != null && !user.getFname().isBlank()) {
                data.setFname(user.getFname());
            }
            if (user.getLname() != null && !user.getLname().isBlank()) {
                data.setLname(user.getLname());
            }
            if (user.getPassword() != null && !user.getPassword().isBlank()) {
                String hashpassword = passwordEncoder.encode(user.getPassword());
                data.setPassword(hashpassword);
            }
            if (user.getUsername() != null && !user.getUsername().isBlank()) {
                data.setUsername(user.getUsername());
            }
            if (user.getRoleId() != null) {
                data.setRoleId(user.getRoleId());
            }
            if (user.getDepartmentId() != null) {
                data.setDepartmentId(user.getDepartmentId());
            }
            if (user.getSalary() != null) {
                data.setSalary(user.getSalary());
            }

            data.setUpdatedAt(now);

            return userRepository.save(data);


        });

    }

}
