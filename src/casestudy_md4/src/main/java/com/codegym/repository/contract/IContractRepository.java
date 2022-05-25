package com.codegym.repository.contract;

import com.codegym.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IContractRepository extends JpaRepository<Contract,Integer> {
}
