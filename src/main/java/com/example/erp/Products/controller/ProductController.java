package com.example.erp.Products.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.erp.Products.model.Product;
import com.example.erp.Products.services.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService){
        this.productService = productService;
    } 

    public List<Product> GetAll(){
        return productService.GetAll();
    }

    public Optional<Product> GetProductById(Integer id){
        
    }


    
    
}
