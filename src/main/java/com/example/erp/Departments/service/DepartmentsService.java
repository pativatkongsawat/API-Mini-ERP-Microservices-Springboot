package com.example.erp.Departments.service;

import com.example.erp.Departments.repository.DepartmentsRepository;

public class DepartmentsService {

    private final DepartmentsRepository departmentsRepository;


    public DepartmentsService(DepartmentsRepository departmentsRepository){
        this.departmentsRepository = departmentsRepository;
    }
    
}
