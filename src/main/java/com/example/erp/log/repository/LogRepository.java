package com.example.erp.Log.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.erp.Log.model.Log;

public interface LogRepository extends JpaRepository<Log , Integer> {
    
}
