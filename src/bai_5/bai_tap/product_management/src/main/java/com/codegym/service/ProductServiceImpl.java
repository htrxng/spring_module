package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
//    @Autowired
//    private static List<Product> productList = new ArrayList<>();
//
//    static {
//        Product product1 = new Product(1, "Pepsi", 10.0, 50, "PepsiCo");
//        Product product2 = new Product(2, "Coca-cola", 9.0, 50, "Coca-cola.Co");
//        Product product3 = new Product(3, "Fanta", 9.0, 40, "Coca-cola.Co");
//        Product product4 = new Product(4, "Sprite", 10.0, 50, "Coca-cola.Co");
//        productList.add(product1);
//        productList.add(product2);
//        productList.add(product3);
//        productList.add(product4);
//    }
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public void addProduct(Product product) {
        iProductRepository.addProduct(product);
    }

    @Override
    public List<Product> getProductList() {
        return iProductRepository.getProductList() ;
    }

    @Override
    public Product findById(Integer id) {
       return iProductRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        iProductRepository.remove(id);
    }

    @Override
    public void update(int productId, Product product) {
        iProductRepository.update(productId,product);
    }

    @Override
    public List<Product> findAllByQuery(String query) {
        return iProductRepository.findAllByQuery(query);
    }
}
