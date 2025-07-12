package com.example.erp.src.Attendance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "attendance_statuses")
public class AttendanceStatus {

    private Integer status_id;
    private String status_name;

    public AttendanceStatus(){}
}
