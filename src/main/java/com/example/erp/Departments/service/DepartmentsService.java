package com.example.erp.Departments.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.erp.Departments.dto.CreateDepartments;
import com.example.erp.Departments.model.Departments;
import com.example.erp.Departments.repository.DepartmentsRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Service
public class DepartmentsService {

    private final DepartmentsRepository departmentsRepository;


    public DepartmentsService(DepartmentsRepository departmentsRepository){
        this.departmentsRepository = departmentsRepository;
    }


    public List<Departments> getAllDepartment(){
        return departmentsRepository.findAll();
    }

    public ResponseEntity<Departments> CreateNewDepartment(@RequestBody CreateDepartments data){

        Departments newData = new Departments();

        newData.setDepartName(data.getDepartName());

        Departments saveData = departmentsRepository.save(newData);

        return ResponseEntity.ok(saveData);
        
        
    }
    
}
