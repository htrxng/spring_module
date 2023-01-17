package com.codegym.service.customer;

import com.codegym.dto.OccupiedCustomerDto;
import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    void save(Customer customer);

    Customer findById(int id);

    void deleteById(Integer id);

    Page<Customer>  findAll(String keyWordNameVal, String keyWordPhoneVal, Integer customerTypeIdVal, Pageable pageable);

    List<Customer> findAllCustomer();

    List<OccupiedCustomerDto> findAllOcc();
}
