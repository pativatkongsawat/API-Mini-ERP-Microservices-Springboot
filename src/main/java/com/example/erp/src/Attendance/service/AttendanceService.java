package com.example.erp.src.Attendance.service;

import com.example.erp.Config.auth.AuthConfig;
import com.example.erp.src.Attendance.model.Attendance;
import com.example.erp.src.Attendance.repository.AttendanceRepository;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;

public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final AuthConfig jwtUtil;

    public AttendanceService(AttendanceRepository attendanceRepository , AuthConfig jwtUtil ){
        this.attendanceRepository = attendanceRepository;
        this.jwtUtil = jwtUtil;

    }

    public Attendance CreateCheckin(Attendance data , HttpServletRequest request){

        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new RuntimeException("Authorization header missing or invalid");
        }

        String token = authHeader.substring(7);

        Claims claims = jwtUtil.extractAllClaims(token);

        String email = claims.getSubject();
        String UserId = claims.get("userId" , String.class);

    }
    
}
