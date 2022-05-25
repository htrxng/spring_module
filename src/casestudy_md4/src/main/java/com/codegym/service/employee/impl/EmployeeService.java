package com.codegym.service.employee.impl;

import com.codegym.model.employee.Employee;
import com.codegym.repository.employee.IEmployeeRepository;
import com.codegym.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public Page<Employee> findAllByPage(Pageable pageable) {
        return iEmployeeRepository.findAll(pageable);
    }

    @Override
    public void save(Employee employee) {
        this.iEmployeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return this.iEmployeeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        this.iEmployeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findAllPaging(String keyWordNameVal, String positionIdVal, String divisionIdVal, Pageable pageable) {
       return this.iEmployeeRepository.findAllByEmployeeNameContainingAndDivisionAndPosition( positionIdVal,
               divisionIdVal, "%" +keyWordNameVal + "%",pageable);
    }
}
