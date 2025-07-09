package com.example.erp.Products.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.erp.Products.dto.CreateProduct;
import com.example.erp.Products.model.Product;
import com.example.erp.Products.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> GetAll() {
        return productRepository.findAll();
    }

    public Optional<Product> GetById(Integer id) {

        return productRepository.findById(id);

    }

    public Product CreateProduct(CreateProduct data) {

        boolean productNotNullAndNotBlank = data.getProductCode() != null && !data.getProductCode().isBlank() &&
                data.getProductName() != null && !data.getProductName().isBlank() &&
                data.getPrice() != null && data.getStock() != null && data.getCategoryID() != null;

        if (!productNotNullAndNotBlank) {

            throw new NoSuchElementException("All fields must have data");

        }

        LocalDateTime now = LocalDateTime.now();

        Product product = new Product();

        product.setProductCode(data.getProductCode());
        product.setProductName(data.getProductName());
        product.setPrice(data.getPrice());
        product.setStock(data.getStock());
        product.setCategoryID(data.getCategoryID());

        product.setCreateAt(now);

        return productRepository.save(product);

    }

    public Optional<Product> UpdateProduct(CreateProduct data, Integer id) {

        boolean productNotNullAndNotBlank = data.getProductCode() == null || data.getProductCode().isBlank() &&
                data.getProductName() == null || data.getProductName().isBlank() &&
                        data.getPrice() == null
                || data.getPrice() <= 0
                        && data.getStock() == null
                || data.getStock() <= 0 && data.getCategoryID() == null || data.getCategoryID() <= 0;

        if (productNotNullAndNotBlank) {

            throw new NoSuchElementException("Add at least 1 field to update");

        }

        return productRepository.findById(id).map(product -> {

            if (data.getProductCode() != null && !data.getProductCode().isBlank()) {
                product.setProductCode(data.getProductCode());
            }
            if (data.getProductName() != null && !data.getProductName().isBlank()) {
                product.setProductName(data.getProductName());
            }
            if (data.getPrice() != null && data.getPrice() > 0) {
                product.setPrice(data.getPrice());
            }
            if (data.getStock() != null && data.getStock() > 0) {
                product.setStock(data.getStock());
            }
            if (data.getCategoryID() != null && data.getCategoryID() > 0) {
                product.setCategoryID(data.getCategoryID());
            }
            return productRepository.save(product);

        }).or(() -> {

            throw new NoSuchElementException("Product ID Not Found");

        });

    }

    public boolean DeleteProduct(Integer id) {
        return productRepository.findById(id).map(data -> {
            productRepository.delete(data);
            return true;

        }).orElseThrow(() -> new NoSuchElementException("Product ID Not Found"));
    }

    public List<Product> CreateProductArray(List<CreateProduct> data) {

        LocalDateTime now = LocalDateTime.now();

        List<Product> products = new ArrayList<>();

        for (CreateProduct newProduct : data) {

            boolean productNotNullAndNotBlank = newProduct.getProductCode() != null
                    && !newProduct.getProductCode().isBlank() &&
                    newProduct.getProductName() != null && !newProduct.getProductName().isBlank() &&
                    newProduct.getPrice() != null && newProduct.getStock() != null
                    && newProduct.getCategoryID() != null;

            if (!productNotNullAndNotBlank) {

                throw new NoSuchElementException("All fields must have data");

            }
            Product product = new Product();
            product.setProductCode(newProduct.getProductCode());
            product.setProductName(newProduct.getProductName());
            product.setStock(newProduct.getStock());
            product.setPrice(newProduct.getPrice());
            product.setCategoryID(newProduct.getCategoryID());

            product.setCreateAt(now);

            products.add(product);

        }
        return productRepository.saveAll(products);

    }
}
