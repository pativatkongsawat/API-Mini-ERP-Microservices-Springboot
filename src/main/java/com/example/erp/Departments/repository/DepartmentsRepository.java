package com.example.erp.Departments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.erp.Departments.model.Departments;

public interface DepartmentsRepository extends JpaRepository<Departments , Integer> {

    
}
