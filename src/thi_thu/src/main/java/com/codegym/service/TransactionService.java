package com.codegym.service;

import com.codegym.model.Transaction;
import com.codegym.repository.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {
    @Autowired
    ITransactionRepository iTransactionRepository;


    @Override
    public void save(Transaction transaction) {
        this.iTransactionRepository.save(transaction);
    }

    @Override
    public Transaction findById(int id) {
        return this.iTransactionRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        this.iTransactionRepository.deleteById(id);
    }

    @Override
    public List<Transaction> findAll(String keyWordServiceTypeVal, Integer customerIdVal) {
        if (customerIdVal == -1) {
            return this.iTransactionRepository.findAllByServiceTypeContaining( '%' +keyWordServiceTypeVal + '%');
        } else {
            return this.iTransactionRepository.findAllByServiceTypeContainingAndCustomer_CustomerId('%' + keyWordServiceTypeVal + '%', customerIdVal);
        }
    }
}
