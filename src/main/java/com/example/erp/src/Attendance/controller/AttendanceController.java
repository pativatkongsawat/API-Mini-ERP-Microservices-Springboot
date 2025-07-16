package com.example.erp.src.Attendance.controller;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.erp.Helper.ApiResponse;
import com.example.erp.src.Attendance.dto.CreateAttendance;
import com.example.erp.src.Attendance.model.Attendance;
import com.example.erp.src.Attendance.service.AttendanceService;


import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping("/in")
    public ResponseEntity<ApiResponse<Attendance>> CreateAttendanceCheckIn(@RequestBody CreateAttendance data,
            HttpServletRequest request) {

        Attendance newData = attendanceService.CreateCheckin(data, request);

        ApiResponse<Attendance> res = new ApiResponse<>("201", "Check In Success", newData);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);

    }

    @PostMapping("/out")
    public ResponseEntity<ApiResponse<Attendance>> CreateAttendanceCheckOut(HttpServletRequest request) {

        Attendance newData = attendanceService.CreateCheckOut(request);

        ApiResponse<Attendance> res = new ApiResponse<>("201", "Check Out Success", newData);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @GetMapping("/")
    public List<Attendance> getAllAttendance() {

        return attendanceService.getAllAttendance();
    }
}
