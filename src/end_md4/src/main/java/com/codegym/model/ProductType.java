package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "productType")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productTypeId;
    private String productTypeName;

    @OneToMany(mappedBy = "productType")
    private List<Product> productList;

    public ProductType() {
    }

    public ProductType(Integer productTypeId, String productTypeName, List<Product> productList) {
        this.productTypeId = productTypeId;
        this.productTypeName = productTypeName;
        this.productList = productList;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
