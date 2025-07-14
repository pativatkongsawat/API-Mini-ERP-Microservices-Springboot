package com.example.erp.src.Leave.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "leaves")
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "leave_id")
    private Integer leaveId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    private String reason;

    @Column(name = "requested_at")
    private LocalDateTime requestedAt;

    @Column(name = "leave_type_id")
    private Integer leaveTypeId;

    @Column(name = "leave_status_id")
    private Integer leaveStatusId;

    
    public Leave() {}

    
    public Integer getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Integer leaveId) {
        this.leaveId = leaveId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }

    public void setRequestedAt(LocalDateTime requestedAt) {
        this.requestedAt = requestedAt;
    }

    public Integer getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(Integer leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public Integer getLeaveStatusId() {
        return leaveStatusId;
    }

    public void setLeaveStatusId(Integer leaveStatusId) {
        this.leaveStatusId = leaveStatusId;
    }
}
