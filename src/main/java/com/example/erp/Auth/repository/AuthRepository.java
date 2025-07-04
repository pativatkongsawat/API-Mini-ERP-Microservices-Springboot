package com.example.erp.Auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.erp.Users.model.User;

public interface AuthRepository extends JpaRepository<User , Integer> {
     
}
