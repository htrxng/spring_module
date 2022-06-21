package com.codegym.service;

import com.codegym.model.ProductOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductOrderService {
    Page<ProductOrder> findAll(Pageable pageable);

    ProductOrder findById(int id);

    void save(ProductOrder productOrder);
}
