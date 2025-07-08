package com.example.erp.Products.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.erp.Products.dto.CreateProduct;
import com.example.erp.Products.model.Product;
import com.example.erp.Products.services.ProductService;
import com.example.erp.helper.ApiResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> GetAll() {
        return productService.GetAll();
    }

    public ResponseEntity<ApiResponse<Product>> GetById(@RequestParam Integer id) {

        Optional<Product> product = productService.GetById(id);

        if (product.isPresent()) {

            ApiResponse<Product> res = new ApiResponse<>("302", "Success", product.get());
            return ResponseEntity.status(HttpStatus.FOUND).body(res);

        } else {
            ApiResponse<Product> res = new ApiResponse<>("404", "Product Not Found", product.get());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
        }

    }

    public ResponseEntity<ApiResponse<Product>> CreateProduct(@RequestBody CreateProduct data){

        Product product = productService.CreateProduct(data);

        ApiResponse<Product> res = new ApiResponse<>("201" , "Success" , product);


        return ResponseEntity.status(HttpStatus.CREATED).body(res);




    }

}
