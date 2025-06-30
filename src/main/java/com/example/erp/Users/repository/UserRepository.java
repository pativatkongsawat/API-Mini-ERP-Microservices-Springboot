package com.example.erp.Users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.erp.Users.model.User;

public interface UserRepository  extends JpaRepository<User , Integer>{

    
}
