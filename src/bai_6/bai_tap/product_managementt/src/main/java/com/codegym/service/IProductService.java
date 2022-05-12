package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    void save(Product product);

    List<Product> getProductList();

    Product findById(Integer id);

    void remove(int id);

    List<Product> findAllByQuery(String query);
}
