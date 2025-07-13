package com.example.erp.src.Attendance.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Attendance {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer attendance_id;
   
    private Integer user_id;
    private LocalDateTime check_in;
    private LocalDateTime check_out;
    private LocalDate work_date; 
    private Integer status_id;

    public Attendance(){}

    public Integer getUserID(){return user_id;}
    public void setUserID(Integer user_id){this.user_id = user_id;}


    public LocalDateTime getCheckIn(){return check_in;}
    public void setChenckIn(LocalDateTime check_in){this.check_in = check_in;}

    public LocalDateTime getCheckOut(){return check_out;}
    public void setCheckOut(LocalDateTime check_out){this.check_out = check_out;}

    public LocalDate setWorkDate(){return work_date;}
    public void setWorkDate(LocalDate work_date){this.work_date = work_date;}

    public Integer getStatusID(){return status_id;}
    public void setStatusID(Integer status_id){this.status_id = status_id;}
    
}
