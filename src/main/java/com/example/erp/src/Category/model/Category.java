package com.example.erp.src.Category.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "category_name")
    private String categoryName;

    public Category(){}

    public Integer getCategoryId(){return categoryId;}
    public void setCategoryID(Integer categoryId){this.categoryId =categoryId;}

    public String getCategoryName(){return categoryName;}
    public void setCategoryName(String categoryName){this.categoryName =categoryName;}
    
}
