package com.example.erp.Users.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.erp.Users.model.User;

public interface UserRepository  extends JpaRepository<User , Integer>{

    Optional<User> findbyEmail(String email);

    
}
