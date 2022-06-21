package com.codegym.repository;

import com.codegym.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductOrderRepository extends JpaRepository<ProductOrder,Integer> {
}
