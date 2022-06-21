package com.codegym.repository;

import com.codegym.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITransactionRepository extends JpaRepository<Transaction,Integer> {
    @Query(value = "select * from `transaction` where service_type like :keyWordServiceTypeVal and customer_id like :customerIdVal",nativeQuery = true)
    List<Transaction> findAllByServiceTypeContainingAndCustomer_CustomerId(String keyWordServiceTypeVal, Integer customerIdVal);

    @Query(value = "select * from `transaction` where service_type like :keyWordServiceTypeVal",nativeQuery = true)
    List<Transaction> findAllByServiceTypeContaining(String keyWordServiceTypeVal);
}
