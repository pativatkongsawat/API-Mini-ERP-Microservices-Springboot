package com.example.erp.src.Leave.service;

import org.springframework.stereotype.Service;

import com.example.erp.src.Leave.repository.LeaveStatusRepository;

@Service
public class LeaveStatusService {

    private LeaveStatusRepository leaveStatusRepository;

    public LeaveStatusService(LeaveStatusRepository leaveStatusRepository){
        this.leaveStatusRepository = leaveStatusRepository;
    }
    
}
