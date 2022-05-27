package com.codegym.dto;

import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.facility.Facility;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class ContractDto implements Validator {
    private Integer contractId;
    private String contractStartDate;
    private String contractEndDate;
    @Pattern(regexp = "[+]?\\d*\\.?\\d*",message = "Deposit must be a number.")
    private String contractDeposit;
    private String contractTotalMoney;
    private Customer customer;
    private Employee employee;
    private Facility facility;

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        if ("".equals(contractDto.contractStartDate)) {
            errors.rejectValue("contractStartDate", "dob.checkEmpty", "giảng làm !");
        } else if (!LocalDate.parse(contractDto.contractStartDate).isAfter(LocalDate.now())) {
            errors.rejectValue("contractStartDate", "contract.checkStartDate", "giảng làm !");
        } else if ("".equals(contractDto.contractEndDate)) {
            errors.rejectValue("contractEndDate", "dob.checkEmpty", "giảng làm !");
        } else if (!LocalDate.parse(contractDto.contractEndDate).isAfter(LocalDate.parse(contractDto.contractStartDate))) {
            errors.rejectValue("contractEndDate", "contract.checkEndDate", "giảng làm !");
        }
        if(contractDto.customer == null) {
            errors.rejectValue("customer","customer.forbidden","An unknown error");
        }
        if(contractDto.employee == null) {
            errors.rejectValue("employee","employee.forbidden","An unknown error");
        }
        if(contractDto.facility == null) {
            errors.rejectValue("facility","facility.forbidden","An unknown error");
        }
    }

    public ContractDto() {
    }



    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(String contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public String getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(String contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


}
