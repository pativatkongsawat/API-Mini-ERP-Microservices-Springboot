package com.example.erp.src.Leave.service;

import org.springframework.stereotype.Service;

import com.example.erp.src.Leave.repository.LeaveRepository;

@Service
public class LeaveService {

    private final LeaveRepository leaveRepository;

    public LeaveService(LeaveRepository leaveRepository){
        this.leaveRepository = leaveRepository;
    }
    
}
