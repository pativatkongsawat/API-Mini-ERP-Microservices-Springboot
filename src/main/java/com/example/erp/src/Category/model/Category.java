package com.example.erp.src.Category.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {

    private Integer category_id;

    private String category_name;

    public Category(){}

    public Integer getCategoryId(){return category_id;}
    public void setCategoryID(Integer category_id){this.category_id =category_id;}

    public String getCategoryName(){return category_name;}
    public void setCategoryName(String category_name){this.category_name =category_name;}
    
}
