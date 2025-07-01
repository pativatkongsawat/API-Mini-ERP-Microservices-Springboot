package com.example.erp.Departments.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.erp.Departments.dto.CreateDepartments;
import com.example.erp.Departments.model.Departments;
import com.example.erp.Departments.repository.DepartmentsRepository;

@Service
public class DepartmentsService {

    private final DepartmentsRepository departmentsRepository;

    public DepartmentsService(DepartmentsRepository departmentsRepository) {
        this.departmentsRepository = departmentsRepository;
    }

    public List<Departments> getAllDepartment() {
        return departmentsRepository.findAll();
    }

    public Departments CreateNewDepartment(CreateDepartments data) {
        if (data.getDepartName() == null || data.getDepartName().isBlank()) {
            throw new IllegalArgumentException("Department name must not be empty or blank.");
        }

        Departments newData = new Departments();
        newData.setDepartName(data.getDepartName());

        return departmentsRepository.save(newData);
    }

    public Optional<Departments> getDepartById(Integer id) {
        return departmentsRepository.findById(id);
    }

}
