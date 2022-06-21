package com.codegym.dto;

import com.codegym.model.Customer;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class TransactionDto implements Validator {

    private Integer transactionId;
    @Pattern(regexp = "MGD-\\d{4}",message = "Mã giao dịch không hợp lệ! \n" +
            "Mẫu: MGD-0001")
    private String transactionCode;
    private String transactionDate;
    private String serviceType;
    @Positive(message = "Deposit must be a number")
    private String bill;
//    @Pattern(regexp = "[+]?\\d*\\.?\\d*",message = "Deposit must be a number.")
    @Positive(message = "Deposit must be a number")
    private String area;
    private Customer customer;

    @Override
    public void validate(Object target, Errors errors) {
        TransactionDto transactionDto = (TransactionDto) target;
        if("".equals(transactionDto.transactionDate)) {
            errors.rejectValue("transactionDate","date.checkEmpty","Lỗi không xác định!");
        } else if (!LocalDate.parse(transactionDto.transactionDate).isAfter(LocalDate.now())) {
            errors.rejectValue("transactionDate", "transactionDate.checkDate", "Lỗi không xác định!");
        }
    }

    public TransactionDto() {
    }



    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


}
