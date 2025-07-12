package com.example.erp.src.Products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.erp.src.Products.model.Product;

public interface ProductRepository  extends JpaRepository<Product , Integer>{

    
}
