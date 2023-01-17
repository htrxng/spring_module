package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements IConvertService {
    private String name;

    @Override
    public double convertMoney(double money, double rate) {
        return money*rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
