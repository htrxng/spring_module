package com.codegym.dto;

import com.codegym.model.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Date;

public class ProductOrderDto implements Validator {

    private Integer orderId;
    private String orderDate;
    @Pattern(regexp = "[+]?[\\d.]+",message = "Số lượng phải là số nguyên dương và không được để trống!")
    private String quantity;
    private Product product;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductOrderDto productOrderDto = (ProductOrderDto) target;
        if("".equals(productOrderDto.orderDate)) {
            errors.rejectValue("orderDate","date.checkEmpty","Lỗi không xác định!");
        } else if (!LocalDate.parse(productOrderDto.orderDate).isAfter(LocalDate.now())) {
            errors.rejectValue("orderDate", "transactionDate.checkDate", "Lỗi không xác định!");
        }
    }

    public ProductOrderDto() {
    }

    public ProductOrderDto(Integer orderId, String orderDate, @Pattern(regexp = "[+]?[\\d.]+", message = "Số lượng phải là số nguyên dương và không được để trống!") String quantity, Product product) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.product = product;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
