package com.example.erp.src.Departments.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateDepartments {

    @NotBlank(message = "Department name is required")
    private String department_name;

    public CreateDepartments(){}

    public String getDepartName(){return department_name;}
    public void setDepartName(String department_name){this.department_name = department_name;}
    
}
