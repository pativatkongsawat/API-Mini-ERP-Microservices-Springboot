package com.example.erp.src.Leave.service;

import org.springframework.stereotype.Service;

import com.example.erp.src.Leave.repository.LeaveTypeRepository;

@Service
public class LeaveTypeService {

    private final LeaveTypeRepository leaveTypeRepository;

    public LeaveTypeService (LeaveTypeRepository leaveTypeRepository){
        this.leaveTypeRepository = leaveTypeRepository;
    }
}
