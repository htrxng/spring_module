package com.codegym.service;

import com.codegym.model.CustomerType;
import com.codegym.repository.ICustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return this.iCustomerTypeRepository.findAll();
    }

    @Override
    public CustomerType findById(Integer id) {
        return iCustomerTypeRepository.findById(id).orElse(null);
    }

}
