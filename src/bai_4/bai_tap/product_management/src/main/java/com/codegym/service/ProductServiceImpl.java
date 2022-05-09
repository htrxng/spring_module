package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private static List<Product> productList = new ArrayList<>();

    static {
        Product product1 = new Product(1, "Pepsi", 10.0, 50, "PepsiCo");
        Product product2 = new Product(2, "Coca-cola", 9.0, 50, "Coca-cola.Co");
        Product product3 = new Product(3, "Fanta", 9.0, 40, "Coca-cola.Co");
        Product product4 = new Product(4, "Sprite", 10.0, 50, "Coca-cola.Co");
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
    }

    @Override
    public void addProduct(Product product) {
        productList.add(product);
    }

    @Override
    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public Product findById(Integer id) {
        Product product = null;
        for (Product p : productList
        ) {
            if (p.getProductId() == id) {
                product = p;
            }
        }
        return product;
    }

    @Override
    public void remove(int id) {
        productList.removeIf(p -> p.getProductId() == id);
    }

    @Override
    public void update(int productId, Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductId() == productId) {
                productList.set(i, product);
            }
        }
    }

    @Override
    public List<Product> findAllByQuery(String query) {
        List<Product> foundedProducts = new ArrayList<>();
        for (Product p: productList
             ) {
            if(p.getProductName().contains(query)) {
                foundedProducts.add(p);
            }
        }
        return foundedProducts;
    }
}
