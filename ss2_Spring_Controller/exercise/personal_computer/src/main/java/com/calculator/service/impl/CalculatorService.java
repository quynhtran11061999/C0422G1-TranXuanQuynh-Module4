package com.calculator.service.impl;

import com.calculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public String calculate(double number1, double number2, String operator) {
        String result = "";
        switch (operator) {
            case "+":
                result = String.valueOf(number1 + number2);
                break;
            case "-":
                result = String.valueOf(number1 - number2);
                break;
            case "*":
                result = String.valueOf(number1 * number2);
                break;
            case "/":
                if (number2 == 0) {
                    result = "\n" +
                            "Can not divided by 0";
                } else {
                    result = String.valueOf(number1 / number2);
                }
                break;
        }
        return result;
    }
}
