package com.codegym.dto;

import com.codegym.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CustomerDto implements Validator {
    private Integer customerId;
    @NotBlank(message = "this information must be not blank")
    private String customerCode;
    @NotBlank(message = "this information must be not blank")
    private String customerName;
    private String customerDateOfBirth;
    private Integer customerGender;
    @NotBlank(message = "this information must be not blank")
    private String customerIdCard;
    @NotBlank(message = "this information must be not blank")
    private String customerPhone;
    @NotBlank(message = "this information must be not blank")
    @Email
    private String customerEmail;
    @NotBlank(message = "this information must be not blank")
    private String customerAddress;
    private CustomerType customerType;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        if(!customerDto.getCustomerCode().matches("KH-\\d{4}")) {
            errors.rejectValue("customerCode","customerCode.forbidden","An unknown error");
        }
        if(!customerDto.getCustomerPhone().matches("((\\(84\\)\\+(90))|(\\(84\\)\\+(91))|(090)|(091))\\d{7}")) {
            errors.rejectValue("customerPhone","phone.forbidden","An unknown error");
        }
        if(!customerDto.getCustomerEmail().matches("([a-z]\\w+@[a-z]{2,}\\.)\\w{2,10}(\\.\\w{2,3})?")) {
            errors.rejectValue("customerEmail","email.forbidden","An unknown error");
        }
        if(!customerDto.getCustomerIdCard().matches("\\d{9}|\\d{12}")) {
            errors.rejectValue("customerIdCard","idCard.forbidden","An unknown error");
        }
        if(customerDto.getCustomerGender()== -1) {
            errors.rejectValue("customerGender","gender.forbidden","An unknown error");
        }
        if(customerDto.getCustomerType() == null) {
            errors.rejectValue("customerType","customerType.forbidden","An unknown error");
        }
    }

    public CustomerDto() {
    }

    public CustomerDto(Integer customerId, String customerCode, String customerName, String customerDateOfBirth, Integer customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress, CustomerType customerType) {
        this.customerId = customerId;
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerDateOfBirth = customerDateOfBirth;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerType = customerType;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerDateOfBirth() {
        return customerDateOfBirth;
    }

    public void setCustomerDateOfBirth(String customerDateOfBirth) {
        this.customerDateOfBirth = customerDateOfBirth;
    }

    public Integer getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Integer customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }


}
