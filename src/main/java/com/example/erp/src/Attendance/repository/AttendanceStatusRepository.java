package com.example.erp.src.Attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.erp.src.Attendance.model.AttendanceStatus;

public interface AttendanceStatusRepository extends JpaRepository<AttendanceStatus , Integer> {

    
}