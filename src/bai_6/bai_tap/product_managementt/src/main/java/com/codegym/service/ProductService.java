package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;



    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public List<Product> getProductList() {
        return iProductRepository.findAll() ;
    }

    @Override
    public Product findById(Integer id) {
       return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public List<Product> findAllByQuery(String query) {
        return iProductRepository.findAllByProductNameContaining(query);
    }
}
