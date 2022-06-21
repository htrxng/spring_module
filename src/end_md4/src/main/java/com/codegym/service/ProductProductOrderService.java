package com.codegym.service;

import com.codegym.model.ProductOrder;
import com.codegym.repository.IProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductProductOrderService implements IProductOrderService {
    @Autowired
    private IProductOrderRepository iProductOrderRepository;

    @Override
    public Page<ProductOrder> findAll(Pageable pageable) {
        return iProductOrderRepository.findAll(pageable);
    }

    @Override
    public ProductOrder findById(int id) {
        return this.iProductOrderRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ProductOrder productOrder) {
        iProductOrderRepository.save(productOrder);
    }
}
