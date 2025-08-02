package com.example.erp.src.Leave.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.erp.src.Leave.model.LeaveType;

public interface LeaveTypeRepository extends JpaRepository<LeaveType , Integer> {

    
}