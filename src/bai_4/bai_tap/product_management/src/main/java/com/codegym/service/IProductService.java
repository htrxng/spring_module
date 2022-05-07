package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    void addProduct(Product product);

    List<Product> getProductList();

    Product findById(Integer id);

    void remove(int id);

    void update(int productId, Product product);

    List<Product> findAllByQuery(String query);
}
