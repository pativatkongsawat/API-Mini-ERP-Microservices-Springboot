package com.example.erp.log.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.erp.log.model.Log;

public interface LogRepository extends JpaRepository<Log , Integer> {
    
}
