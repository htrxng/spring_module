package com.codegym.repository.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    Page<Customer> findAllByCustomerNameContainingAndCustomerPhoneContaining(String keyWordNameVal, String keyWordPhoneVal, Pageable pageable);

    Page<Customer> findAllByCustomerNameContainingAndCustomerPhoneContainingAndCustomerType_CustomerTypeId(String keyWordNameVal, String keyWordPhoneVal, Integer customerTypeIdVal, Pageable pageable);
}
