package com.codegym.service;

import com.codegym.model.Transaction;

import java.util.List;

public interface ITransactionService {
   

    void save(Transaction transaction);

    Transaction findById(int id);

    void deleteById(int id);

    List<Transaction> findAll(String keyWordServiceTypeVal, Integer customerIdVal);
}
