package com.example.erp.Attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.erp.Attendance.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance , Integer> {

    
}