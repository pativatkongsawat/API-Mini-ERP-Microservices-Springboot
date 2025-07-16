package com.example.erp.src.Category.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.erp.src.Category.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category , Integer> {

    
}