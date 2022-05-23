package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
   @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return this.iCustomerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByPage(String keywordVal, Pageable pageable) {
        return iCustomerRepository.findAllByCustomerNameContaining(keywordVal,pageable);
    }
}
