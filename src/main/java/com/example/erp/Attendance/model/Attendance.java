package com.example.erp.Attendance.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Attendance {

    private Integer attendance_id;
    private Integer user_id;
    private LocalDateTime check_in;
    private LocalDateTime check_out;
    private LocalDate work_date; 
    private Integer status_id;
    
}
