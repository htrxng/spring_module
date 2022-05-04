package com.codegym.service.impl;

import com.codegym.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService {

    @Override
    public Integer calcutator(Integer a, Integer b, String operator) {
        Integer result = null;
        switch (operator) {
            case "addition":
                result = a+b;
                break;
            case "subtraction":
                result = a-b;
                break;
            case "multiplication":
                result = a*b;
                break;
            case "division":
                result = a/b;
                break;
        }
        return result;
    }
}
