package com.example.erp.Departments.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.erp.Departments.dto.CreateDepartments;
import com.example.erp.Departments.model.Departments;
import com.example.erp.Departments.service.DepartmentsService;
import com.example.erp.Helper.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/dp")
public class DepartmentsController {

    private final DepartmentsService departmentsService;

    public DepartmentsController(DepartmentsService departmentsService) {

        this.departmentsService = departmentsService;

    }

    @GetMapping("/")
    public List<Departments> getAll() {
        return departmentsService.getAllDepartment();
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<Departments>> createDeart(@Valid @RequestBody CreateDepartments data) {
        Departments created = departmentsService.CreateNewDepartment(data);
        ApiResponse<Departments> response = new ApiResponse<>("success",
                "Department created successfully",
                created);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Departments>> getById(@PathVariable Integer id) {

        Optional<Departments> getData = departmentsService.getDepartById(id);

        if (getData.isPresent()) {
            ApiResponse<Departments> res = new ApiResponse<>("Success", "Department found", getData.get());
            return ResponseEntity.ok(res);
        } else {
            ApiResponse<Departments> res = new ApiResponse<>("Error", "Department not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
        }
    }

}
