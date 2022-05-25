package com.codegym.service.employee;

import com.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    Page<Employee> findAllByPage(Pageable pageable);

    void save(Employee employee);

    Employee findById(int id);

    void deleteById(int id);

    Page<Employee> findAllPaging(String keyWordNameVal, String positionIdVal, String divisionIdVal, Pageable pageable);
}
