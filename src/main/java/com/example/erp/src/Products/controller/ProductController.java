package com.example.erp.src.Products.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.erp.Helper.ApiResponse;
import com.example.erp.src.Products.dto.CreateProduct;
import com.example.erp.src.Products.model.Product;
import com.example.erp.src.Products.services.ProductService;



@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> GetAll() {
        return productService.GetAll();
    }

    @GetMapping("/")
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

    @PostMapping("/")
    public ResponseEntity<ApiResponse<Product>> CreateProduct(@RequestBody CreateProduct data){

        Product product = productService.CreateProduct(data);

        ApiResponse<Product> res = new ApiResponse<>("201" , "Success" , product);


        return ResponseEntity.status(HttpStatus.CREATED).body(res);

    }

    @DeleteMapping("/")
    public ResponseEntity<Void> DeleteProduct (@RequestParam Integer id){
        productService.DeleteProduct(id);

        return ResponseEntity.noContent().build();
    }


    @PostMapping("/array")
    public ResponseEntity<ApiResponse<List<Product>>> CreateProductArray(@RequestBody List<CreateProduct> data){

        List<Product> products = productService.CreateProductArray(data);

        ApiResponse<List<Product>> res = new ApiResponse<>("201" , "Create Product Succes" , products);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
        
    }

    @PutMapping("/")
    public ResponseEntity<ApiResponse<Product>> UpdateProduct (@RequestBody CreateProduct data , Integer id){

        Optional<Product> products  = productService.UpdateProduct(data, id);

        ApiResponse<Product>  res = new ApiResponse<>("200" , "Update Product Suceess" , products.get());

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

}
