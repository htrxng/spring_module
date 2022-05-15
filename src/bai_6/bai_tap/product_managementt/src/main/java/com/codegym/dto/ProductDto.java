package com.codegym.dto;

import javax.validation.constraints.NotEmpty;

public class ProductDto {
    private Integer productId;

    @NotEmpty(message = "name can not be empty")
    private String productName;
    @NotEmpty(message = "price can not be empty")
    private Double price;
    @NotEmpty(message = "quantity can not be empty")
    private Integer quantity;
    @NotEmpty(message = "manufacturer can not be empty")
    private String manufacturer;

    public ProductDto() {
    }

    public ProductDto(Integer productId, String productName, Double price, Integer quantity, String manufacturer) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.manufacturer = manufacturer;
    }


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
