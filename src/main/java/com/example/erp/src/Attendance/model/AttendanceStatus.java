package com.example.erp.src.Attendance.model;

import jakarta.persistence.Column;
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
    @Column(name = "status_id")
    private Integer statusId;

    @Column(name = "status_name")
    private String statusName;

    public AttendanceStatus(){}

    public Integer getStatusId(){return statusId ;}
    public void setStatusId(Integer statusId){this.statusId = statusId;}

    public String getStatusName(){return statusName;}
    public void setStatusName(String statusName){this.statusName = statusName;}

    
}
