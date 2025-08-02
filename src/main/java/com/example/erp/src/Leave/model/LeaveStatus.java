package com.example.erp.src.Leave.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "leave_statuses")
public class LeaveStatus {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "leave_status_id")
    private Integer leaveStatusId;


    @Column(name = "leave_status_name")
    private String leaveStatusName;

    public LeaveStatus(){}

    public Integer getStatusId(){return leaveStatusId;}
    public void  setStatusId(Integer leaveStatusId ){this.leaveStatusId = leaveStatusId;}

    public String getStatusName(){return leaveStatusName;}
    public void setStatusName(String leaveStatusName){this.leaveStatusName = leaveStatusName;}

}
