package com.example.erp.Products.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
 
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer product_id;

    private String product_code;

    private String name;

    private Integer stock;

    private Double price;

    private LocalDateTime created_at;


    public Product(){}

    public Integer getProductID(){return product_id;}
    public void setProductID(Integer product_id){this.product_id = product_id;}

    public String getProductCode(){return product_code;}
    public void setProductCode(String product_code){this.product_code = product_code;}

    public String getProductName(){return name;}
    public void setProductName(String name){this.name = name;}

    public Integer getStock(){return stock;}
    public void setStock(Integer stock){this.stock = stock;}

    public Double getPrice(){return price;}
    public void setPrice(Double price){this.price = price;}

    public LocalDateTime getCrateAt(){return created_at;}
    public void setCreateAt(LocalDateTime created_at){this.created_at = created_at;}

}
