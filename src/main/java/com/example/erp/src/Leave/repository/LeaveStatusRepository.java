package com.example.erp.src.Leave.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.erp.src.Leave.model.LeaveStatus;

public interface LeaveStatusRepository extends JpaRepository<LeaveStatus , Integer>{

    
}
