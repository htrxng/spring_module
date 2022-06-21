package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String productName;
    private Double productPrice;
    private String status;

    @ManyToOne
    @JoinColumn(name = "product_type_id",referencedColumnName = "productTypeId")
    private ProductType productType;

    @OneToMany(mappedBy = "product")
    private List<ProductOrder> productOrderList;

    public Product() {
    }

    public Product(Integer productId, String productName, Double productPrice, String status, ProductType productType, List<ProductOrder> productOrderList) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.status = status;
        this.productType = productType;
        this.productOrderList = productOrderList;
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

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public List<ProductOrder> getProductOrderList() {
        return productOrderList;
    }

    public void setProductOrderList(List<ProductOrder> productOrderList) {
        this.productOrderList = productOrderList;
    }
}
