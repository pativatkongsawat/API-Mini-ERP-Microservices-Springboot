package com.example.erp.src.Users.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.erp.src.Users.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Optional<User> findByFirstNameAndLastName(String firstName, String lastName);

    

    Page<User> findAll(Pageable pageable);

    Page<User> findByFirstNameAndLastNameAndDepartmentId(
        String firstName, String lastName, Integer departmentId, Pageable pageable
    );

    

    

    
}
