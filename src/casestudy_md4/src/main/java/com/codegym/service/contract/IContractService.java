package com.codegym.service.contract;

import com.codegym.model.contract.Contract;

import java.util.List;

public interface IContractService {
    List<Contract> findAll();

    void save(Contract contract);

    Contract findById(int id);
}
