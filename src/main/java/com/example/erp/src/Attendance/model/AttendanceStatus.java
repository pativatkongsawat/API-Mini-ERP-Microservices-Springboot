package com.example.erp.src.Attendance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "attendance_statuses")
public class AttendanceStatus {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer status_id;
    private String status_name;

    public AttendanceStatus(){}

    public Integer getStatusId(){return status_id;}
    public void setStatusId(Integer status_id){this.status_id = status_id;}

    public String getStatusName(){return status_name;}
    public void setStatusName(String status_name){this.status_name = status_name;}

    
}
