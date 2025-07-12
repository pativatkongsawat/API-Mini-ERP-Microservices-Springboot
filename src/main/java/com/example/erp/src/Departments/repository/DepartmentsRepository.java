package com.example.erp.src.Departments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.erp.src.Departments.model.Departments;

public interface DepartmentsRepository extends JpaRepository<Departments , Integer> {

    
}
