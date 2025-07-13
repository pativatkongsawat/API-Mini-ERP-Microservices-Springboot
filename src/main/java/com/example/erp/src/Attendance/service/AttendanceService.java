package com.example.erp.src.Attendance.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.erp.Config.auth.AuthConfig;
import com.example.erp.src.Attendance.dto.CreateAttendance;
import com.example.erp.src.Attendance.model.Attendance;
import com.example.erp.src.Attendance.repository.AttendanceRepository;
import com.example.erp.src.Users.repository.UserRepository;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;

public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final AuthConfig jwtUtil;
    private final UserRepository userRepository;

    public AttendanceService(AttendanceRepository attendanceRepository, AuthConfig jwtUtil ,
            UserRepository userRepository) {
        this.attendanceRepository = attendanceRepository;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;

    }

    public Attendance CreateCheckin(CreateAttendance data, HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new RuntimeException("Authorization header missing or invalid");
        }

        LocalDateTime now = LocalDateTime.now(); 
        LocalDate dateNow = LocalDate.now();

        String token = authHeader.substring(7);
        Claims claims = jwtUtil.extractAllClaims(token);
        Integer UserId = claims.get("userId", Integer.class);

        
        LocalDateTime onTimeStart = dateNow.atTime(9, 0); 

        int statusId;
        if (now.isAfter(onTimeStart)) {
            statusId = 3; 
        } else {
            statusId = 1; 
        }

        Attendance newData = new Attendance();
        newData.setUserID(UserId);
        newData.setChenckIn(now);
        newData.setCheckOut(null);
        newData.setWorkDate(dateNow);
        newData.setStatusID(statusId); 

        return attendanceRepository.save(newData);
    }

}
