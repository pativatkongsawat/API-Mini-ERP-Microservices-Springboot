package com.example.erp.src.Attendance.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.erp.Helper.ApiResponse;
import com.example.erp.src.Attendance.dto.CreateAttendanceStatus;
import com.example.erp.src.Attendance.model.AttendanceStatus;
import com.example.erp.src.Attendance.service.AttendanceService;



@RestController
@RequestMapping("/api/attendance/status")
public class AttendanceStatusController {

    private final AttendanceService attendanceService;

    public AttendanceStatusController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<AttendanceStatus>> CreateAttendanceStatus(
            @RequestBody CreateAttendanceStatus data) {

        AttendanceStatus newData = attendanceService.CreateAttendanceStatus(data);

        ApiResponse<AttendanceStatus> res = new ApiResponse<>("201", "Create Status Success", newData);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);

    }

    @DeleteMapping("/")
    public ResponseEntity<Void> DeleteAttendanceStatus(@RequestParam Integer id) {
        
        attendanceService.DeleteAttendanceStatus(id);

        return ResponseEntity.noContent().build();
    }

}
