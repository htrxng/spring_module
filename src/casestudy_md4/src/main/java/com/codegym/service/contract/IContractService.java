package com.codegym.service.contract;

import com.codegym.model.contract.Contract;

import java.util.List;

public interface IContractService {
    List<Contract> findAll();
}
