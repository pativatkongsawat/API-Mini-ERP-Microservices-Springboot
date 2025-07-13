package com.example.erp.src.Attendance.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CreateAttendance {
    private Integer user_id;
    private LocalDateTime check_in;
    private LocalDateTime check_out;
    private LocalDate work_date; 
    private Integer status_id;

    public CreateAttendance(){}
}
