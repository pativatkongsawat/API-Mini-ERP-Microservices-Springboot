package com.example.erp.src.Attendance.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.erp.Config.auth.AuthConfig;
import com.example.erp.src.Attendance.dto.CreateAttendance;
import com.example.erp.src.Attendance.model.Attendance;
import com.example.erp.src.Attendance.model.AttendanceStatus;
import com.example.erp.src.Attendance.repository.AttendanceRepository;
import com.example.erp.src.Attendance.repository.AttendanceStatusRepository;
import com.example.erp.src.Users.model.User;
import com.example.erp.src.Users.repository.UserRepository;
import com.example.erp.src.Attendance.dto.CreateAttendanceStatus;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final AuthConfig jwtUtil;
    private final UserRepository userRepository;
    private final AttendanceStatusRepository attendanceStatusRepository;

    public AttendanceService(AttendanceRepository attendanceRepository, AuthConfig jwtUtil,
            UserRepository userRepository, AttendanceStatusRepository attendanceStatusRepository) {
        this.attendanceRepository = attendanceRepository;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
        this.attendanceStatusRepository = attendanceStatusRepository;

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
        newData.setUserId(UserId);
        newData.setCheckIn(now);
        newData.setCheckOut(null);
        newData.setWorkDate(dateNow);
        newData.setStatusId(statusId);

        return attendanceRepository.save(newData);
    }

    @Scheduled(cron = "0 0 17 * * *")
    public void checkAbsentUsers() {

        LocalDate today = LocalDate.now();
        List<User> allUsers = userRepository.findAll();

        for (User user : allUsers) {
            boolean hashCheckin = attendanceRepository.existsByUserIdAndWorkDate(user.getId(), today);

            if (!hashCheckin) {
                Attendance absent = new Attendance();

                absent.setUserId(user.getId());
                absent.setCheckIn(null);
                absent.setCheckOut(null);
                absent.setStatusId(2);
                absent.setWorkDate(today);

                attendanceRepository.save(absent);
            }
        }

    }

    public Attendance CreateCheckOut(CreateAttendance data, HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new RuntimeException("Authorization header missing or invalid");
        }

        String token = authHeader.substring(7);
        Claims claims = jwtUtil.extractAllClaims(token);
        Integer userId = claims.get("userId", Integer.class);

        LocalDate today = LocalDate.now();
        LocalDateTime now = LocalDateTime.now();

        Attendance attendance = attendanceRepository
                .findByUserIdAndWorkDateAndCheckOutIsNull(userId, today)
                .orElseThrow(() -> new RuntimeException("Check-in not found for today"));

        attendance.setCheckOut(now);

        return attendanceRepository.save(attendance);
    }

    public AttendanceStatus CreateAttendanceStatus(CreateAttendanceStatus data) {

        AttendanceStatus status = new AttendanceStatus();

        status.setStatusName(data.getStatusName());

        return attendanceStatusRepository.save(status);

    }

    public boolean DeleteAttendanceStatus(Integer id) {

        return attendanceStatusRepository.findById(id).map(data -> {
            attendanceStatusRepository.delete(data);
            return true;
        }).orElseThrow(() -> new NoSuchElementException("Not Found this ID"));

    }

}
