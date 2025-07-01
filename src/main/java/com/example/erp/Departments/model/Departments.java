package com.example.erp.Departments.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "departments")
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer department_id;

    private String department_name;

    public Departments(){}


    public Integer getDepartId(){return department_id;}
    public void setDepartId(Integer department_id){this.department_id =department_id;}

    public String getDepartName(){return department_name;}
    public void setDepartName(String department_name){this.department_name = department_name;}
    
}
