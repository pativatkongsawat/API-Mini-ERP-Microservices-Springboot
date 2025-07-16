package com.example.erp.src.Category.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/")
    public List<Category> GetAll() {
        return categoryService.GetAll();

    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<Category>> CreateCategory(@RequestBody CreateCategory data) {

        Category category = categoryService.CreateCategory(data);
        
        ApiResponse<Category> res = new ApiResponse<>("201" , "Create Category Success" , category);


        return ResponseEntity.status(HttpStatus.CREATED).body(res);

    }

    @DeleteMapping("/")
    public ResponseEntity<Void> DeleteCategory(@RequestParam Integer id){

        categoryService.DeleteCategory(id);

        return ResponseEntity.noContent().build();

    }
}
