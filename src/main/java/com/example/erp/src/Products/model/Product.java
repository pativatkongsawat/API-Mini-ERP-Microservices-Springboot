package com.example.erp.src.Products.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer product_id;

    @Column(name = "product_code")
    private String product_code;

    @Column(name = "name")
    private String name;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "price")
    private Double price;

    @Column(name = "category_id")
    private Integer category_id;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    public Product() {}

    public Integer getProductID() {
        return product_id;
    }

    public void setProductID(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProductCode() {
        return product_code;
    }

    public void setProductCode(String product_code) {
        this.product_code = product_code;
    }

    public String getProductName() {
        return name;
    }

    public void setProductName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getCrateAt() {
        return created_at;
    }

    public void setCreateAt(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public Integer getCategoryID() {
        return category_id;
    }

    public void setCategoryID(Integer category_id) {
        this.category_id = category_id;
    }
}
