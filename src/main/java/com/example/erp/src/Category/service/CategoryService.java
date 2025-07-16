
package com.example.erp.src.Category.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.erp.src.Category.dto.CreateCategory;
import com.example.erp.src.Category.model.Category;
import com.example.erp.src.Category.repository.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

    public List<Category> GetAll() {
        return categoryRepository.findAll();
    }

    public Category CreateCategory(CreateCategory data) {

        if (data.getCategoryName() == null || data.getCategoryName().isBlank()) {

            throw new NoSuchElementException("Add Category Name to Create Category");

        }

        Category newData = new Category();

        newData.setCategoryName(data.getCategoryName());

        return categoryRepository.save(newData);

    }

    public boolean DeleteCategory(Integer id) {

        return categoryRepository.findById(id).map(data -> {
            categoryRepository.delete(data);
            return true;
        }).orElseThrow(() -> new NoSuchElementException("Not Found This Id"));

    }

}