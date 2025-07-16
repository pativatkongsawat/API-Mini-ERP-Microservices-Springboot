package com.example.erp.src.Category.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.erp.Helper.ApiResponse;
import com.example.erp.src.Category.dto.CreateCategory;
import com.example.erp.src.Category.model.Category;
import com.example.erp.src.Category.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public List<Category> GetAll() {
        return categoryService.GetAll();

    }

    public ResponseEntity<ApiResponse<Category>> CreateCategory(@RequestBody CreateCategory data) {


    }
}
