package com.codegym.service.impl;

import com.codegym.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService {

    @Override
    public String calcutator(Integer a, Integer b, String operator) {
        String result = null;

        switch (operator) {
            case "addition":
                result = String.valueOf(a + b);
                break;
            case "subtraction":
                result = String.valueOf(a - b);
                break;
            case "multiplication":
                result = String.valueOf(a * b);
                break;
            case "division":
                if (b != 0) {
                    result = String.valueOf(a / b);
                    break;
                } else {
                    result = "ko chia cho 0";
                    break;
                }
        }
        return result;
    }
}
