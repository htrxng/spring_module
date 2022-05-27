package com.codegym.repository.employee;

import com.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEmployeeRepository  extends JpaRepository<Employee,Integer> {
    @Query(value = "select * from employee where position_id like :positionIdVal and division_id like :divisionIdVal " +
            "and employee_name like :keyWordNameVal",
            countQuery = "select * from employee  where position_id like :positionIdVal and division_id " +
                    "like :divisionIdVal and employee_name like :keyWordNameVal",
            nativeQuery = true)
    Page<Employee> findAllByEmployeeNameContainingAndDivisionAndPosition(
             String positionIdVal,  String divisionIdVal, String keyWordNameVal, Pageable pageable);
}
