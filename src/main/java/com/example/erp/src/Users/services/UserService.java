package com.example.erp.src.Users.services;

import java.util.NoSuchElementException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.erp.src.Users.dto.CreateUser;
import com.example.erp.src.Users.model.User;
import com.example.erp.src.Users.repository.UserRepository;

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

        boolean allFieldsHaveData = user.getEmail() != null && !user.getEmail().isBlank() &&
                user.getFname() != null && !user.getFname().isBlank() &&
                user.getLname() != null && !user.getLname().isBlank() &&
                user.getPassword() != null && !user.getPassword().isBlank() &&
                user.getUsername() != null && !user.getUsername().isBlank() &&
                user.getRoleId() != null &&
                user.getDepartmentId() != null &&
                user.getSalary() != null;

        if (!allFieldsHaveData) {
            throw new IllegalArgumentException("All fields must have data");
        }

        LocalDateTime now = LocalDateTime.now();

        String hashpassword = passwordEncoder.encode(user.getPassword());

        User data = new User();
        data.setUserId(user.getUserId());
        data.setUsername(user.getUsername());
        data.setEmail(user.getEmail());
        data.setPassword(hashpassword);
        data.setFirstName(user.getFname());
        data.setLastName(user.getLname());
        data.setDepartmentId(user.getDepartmentId());
        data.setRoleId(user.getRoleId());
        data.setSalary(user.getSalary());

        data.setHireDate(now);
        data.setActive(true);
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

        return userRepository.findById(id).map(data -> {
            if (user.getEmail() != null && !user.getEmail().isBlank()) {
                data.setEmail(user.getEmail());
            }
            if (user.getFname() != null && !user.getFname().isBlank()) {
                data.setFirstName(user.getFname());
            }
            if (user.getLname() != null && !user.getLname().isBlank()) {
                data.setLastName(user.getLname());
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

            data.setUpdatedAt(LocalDateTime.now());
            return userRepository.save(data);
        }).or(() -> {

            throw new NoSuchElementException("User not found with id: " + id);

        });
    }

    public boolean DeleteUser(Integer id) {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));
    }

    public Optional<User> SoftDeleteUser(Integer id) {
        return userRepository.findById(id).map(data -> {
            data.setActive(false);
            data.setUpdatedAt(LocalDateTime.now());
            return userRepository.save(data);
        }).or(() -> {
            throw new NoSuchElementException("User not found with id: " + id);
        });
    }

    public List<User> CreateProductArray(List<CreateUser> data) {

        LocalDateTime now = LocalDateTime.now();

        List<User> users = new ArrayList<>();

        for (CreateUser newUser : data) {

            boolean allFieldsHaveData = newUser.getEmail() != null && !newUser.getEmail().isBlank() &&
                    newUser.getFname() != null && !newUser.getFname().isBlank() &&
                    newUser.getLname() != null && !newUser.getLname().isBlank() &&
                    newUser.getPassword() != null && !newUser.getPassword().isBlank() &&
                    newUser.getUsername() != null && !newUser.getUsername().isBlank() &&
                    newUser.getRoleId() != null &&
                    newUser.getDepartmentId() != null &&
                    newUser.getSalary() != null;

            if (!allFieldsHaveData) {
                throw new IllegalArgumentException("All fields must have data");
            }

            String hashpassword = passwordEncoder.encode(newUser.getPassword());

            User user = new User();
            user.setUserId(newUser.getUserId());
            user.setUsername(newUser.getUsername());
            user.setEmail(newUser.getEmail());
            user.setPassword(hashpassword);
            user.setFirstName(newUser.getFname());
            user.setLastName(newUser.getLname());
            user.setDepartmentId(newUser.getDepartmentId());
            user.setRoleId(newUser.getRoleId());
            user.setSalary(newUser.getSalary());

            user.setHireDate(now);
            user.setActive(true);
            user.setCreatedAt(now);
            user.setUpdatedAt(now);

            users.add(user);

        }

        return userRepository.saveAll(users);

    }
}
