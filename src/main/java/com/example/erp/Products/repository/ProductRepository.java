package com.example.erp.Products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.erp.Products.model.Product;

public interface ProductRepository  extends JpaRepository<Product , Integer>{

    
}
