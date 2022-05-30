package com.codegym.repository.customer;

import com.codegym.dto.OccupiedCustomerDto;
import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findAllByCustomerNameContainingAndCustomerPhoneContaining(String keyWordNameVal, String keyWordPhoneVal, Pageable pageable);

    Page<Customer> findAllByCustomerNameContainingAndCustomerPhoneContainingAndCustomerType_CustomerTypeId(String keyWordNameVal, String keyWordPhoneVal, Integer customerTypeIdVal, Pageable pageable);


    @Query(value = "select cus.customer_id as occCustomerId ,cus.customer_code as occCustomerCode,cus.customer_name as occCustomerName, cus_type.customer_type_name as occCustomerTypeName, con.contract_start_date as occStartDate, con.contract_end_date as occEndDate, att_sv.attach_service_name as attachServiceName, att_sv.attach_service_status as attachServiceStatus, con_dt.quantity as quantity from customer cus inner join customer_type cus_type on cus.customer_type_id = cus_type.customer_type_id inner join contract con on con.customer_id = cus.customer_id inner join contract_detail con_dt on con_dt.contract_id = con.contract_id inner join attach_service att_sv on att_sv.attach_service_id = con_dt.attach_service_id where datediff(con.contract_end_date, current_date()) > 0 group by con.contract_id", nativeQuery = true)
    List<OccupiedCustomerDto> findAllOcc();
}
