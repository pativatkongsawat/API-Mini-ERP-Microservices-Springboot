package com.example.erp.Users.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.erp.Users.model.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Optional<User> findByFirstNameAndLastName(String first_name, String last_name);

    List<User> findByIsActive(boolean isActive);

    Page<User> findAll(Pageable pageable);
    
    Page<User> findByFirstNameAndLastName(String first_name, String last_name, Pageable pageable);
}


