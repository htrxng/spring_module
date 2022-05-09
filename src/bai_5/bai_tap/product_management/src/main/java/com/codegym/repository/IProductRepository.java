package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getProductList();

    void addProduct(Product product);

    Product findById(Integer id);

    void remove(int id);

    void update(int productId, Product product);

    List<Product> findAllByQuery(String query);
}
