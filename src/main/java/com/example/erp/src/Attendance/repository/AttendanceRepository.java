package com.example.erp.src.Attendance.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.erp.src.Attendance.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance , Integer> {

    boolean existsByUserIdAndWorkDate(Integer userId, LocalDate workDate);
    

}