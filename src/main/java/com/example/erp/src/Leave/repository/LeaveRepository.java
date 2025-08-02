package com.example.erp.src.Leave.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.erp.src.Leave.model.Leave;

public interface LeaveRepository extends JpaRepository<Leave , Integer>{

    
}