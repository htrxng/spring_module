package com.codegym.repository;

import com.codegym.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository  extends JpaRepository<Order,Integer> {
}
