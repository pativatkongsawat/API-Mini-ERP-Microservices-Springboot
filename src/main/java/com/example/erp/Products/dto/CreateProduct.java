package com.example.erp.Products.dto;

public class CreateProduct {

    private String product_code;

    private String name;

    private Integer stock;

    private Double price;
    
    private Integer category_id;

    public CreateProduct(){}

    public String getProductCode(){return product_code;}
    public void setProductCode(String product_code){this.product_code = product_code;}

    public String getProductName(){return name;}
    public void setProductName(String name){this.name = name;}

    public Integer getStock(){return stock;}
    public void setStock(Integer stock){this.stock = stock;}

    public Double getPrice(){return price;}
    public void setPrice(Double price){this.price = price;}

    public Integer getCategoryID(){return category_id;}
    public void setCategoryID(Integer category_id){this.category_id =category_id;}


}
