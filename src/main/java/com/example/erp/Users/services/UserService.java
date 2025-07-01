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

    public UserService(UserRepository userRepository , PasswordEncoder passwordEncoder) {
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

}
