package com.codegym.service.customer.impl;

import com.codegym.model.customer.Customer;
import com.codegym.repository.customer.ICustomerRepository;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
   @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public void save(Customer customer) {
        this.iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        this.iCustomerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAll(String keyWordNameVal, String keyWordPhoneVal, Integer customerTypeIdVal, Pageable pageable) {
        if(customerTypeIdVal == -1) {
            return this.iCustomerRepository.findAllByCustomerNameContainingAndCustomerPhoneContaining(keyWordNameVal,keyWordPhoneVal,pageable);
        } else {
            return this.iCustomerRepository.findAllByCustomerNameContainingAndCustomerPhoneContainingAndCustomerType_CustomerTypeId(keyWordNameVal,keyWordPhoneVal,customerTypeIdVal,pageable);
        }
    }

}
