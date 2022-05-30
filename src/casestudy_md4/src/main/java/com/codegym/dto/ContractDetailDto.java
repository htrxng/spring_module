package com.codegym.dto;

import com.codegym.model.contract.AttachService;
import com.codegym.model.contract.Contract;

public class ContractDetailDto {
    private Integer contractDetailId;
    private AttachService attachService;
    private Contract contract;
    private Integer quantity;

    public ContractDetailDto() {
    }

    public ContractDetailDto(Integer contractDetailId, AttachService attachService, Contract contract, Integer quantity) {
        this.contractDetailId = contractDetailId;
        this.attachService = attachService;
        this.contract = contract;
        this.quantity = quantity;
    }

    public Integer getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Integer contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
