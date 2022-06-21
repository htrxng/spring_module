package com.codegym.service;

import com.codegym.model.Order;
import com.codegym.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository iOrderRepository;


    @Override
    public Page<Order> findAll(Pageable pageable) {
        return this.iOrderRepository.findAll((org.springframework.data.domain.Pageable) pageable);
    }
}
