package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {

    void save(Customer customer);

    Customer findById(int id);

    void deleteById(Integer id);

    Page<Customer>  findAll(String keyWordNameVal, String keyWordPhoneVal, Integer customerTypeIdVal, Pageable pageable);
}
