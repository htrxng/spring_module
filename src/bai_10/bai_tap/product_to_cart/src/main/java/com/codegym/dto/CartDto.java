package com.codegym.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class CartDto {
    private Map<ProductDto, Integer> productDtoMap = new HashMap<>();

    public void addProduct(ProductDto productDto) {
        if (productDtoMap.containsKey(productDto)) {
            Integer currentValue = productDtoMap.get(productDto);
            productDtoMap.put(productDto, currentValue + 1);
        } else {
            productDtoMap.put(productDto, 1);
        }
    }

    public void decreaseProduct(ProductDto productDto) {
        if (productDtoMap.containsKey(productDto)) {
            Integer currentValue = productDtoMap.get(productDto);
            if (currentValue > 1) {
                productDtoMap.put(productDto, currentValue - 1);
            } else {
                productDtoMap.remove(productDto);
            }
        }
    }


    public boolean checkItemInCart(ProductDto product) {
        for (Map.Entry<ProductDto, Integer> entry : productDtoMap.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    public Map.Entry<ProductDto, Integer> selectItemInCart(ProductDto product) {
        for (Map.Entry<ProductDto, Integer> entry : productDtoMap.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }


    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<ProductDto, Integer> entry : productDtoMap.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity() {
        return productDtoMap.size();
    }

    public Float countTotalPayment() {
        float payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : productDtoMap.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
}
