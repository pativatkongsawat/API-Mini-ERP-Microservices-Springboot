package com.example.erp.Products.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.erp.Products.model.Product;
import com.example.erp.Products.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> GetAll(){
        return productRepository.findAll();
    }
    
}
