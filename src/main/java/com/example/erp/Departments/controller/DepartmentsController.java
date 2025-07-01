package com.example.erp.Departments.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.erp.Departments.dto.CreateDepartments;
import com.example.erp.Departments.model.Departments;
import com.example.erp.Departments.service.DepartmentsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/dp")
public class DepartmentsController {

    private final DepartmentsService departmentsService;


    public DepartmentsController(DepartmentsService departmentsService){

        this.departmentsService =departmentsService;

    }


    @GetMapping("/")
    public List<Departments> getAll(){
        return departmentsService.getAllDepartment();
    }

    @PostMapping("/")
    public ResponseEntity<Departments> createDeart(@Valid @RequestBody CreateDepartments data){

        return departmentsService.CreateNewDepartment(data);

    }
    
}
