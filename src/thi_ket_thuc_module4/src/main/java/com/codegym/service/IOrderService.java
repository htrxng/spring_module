package com.codegym.service;

import com.codegym.model.Order;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface IOrderService {
    Page<Order> findAll(Pageable pageable);
}
