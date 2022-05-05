package com.codegym.controller;


import com.codegym.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    ICalculatorService iCalculatorService;

    @GetMapping("/")
    public String goIndex() {
        return "index";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam("firstNumber") Integer firstNumber,
                            @RequestParam("secondNumber") Integer secondNumber,
                            @RequestParam("operator") String operator,
                            Model model) {
        model.addAttribute("results", this.iCalculatorService.calcutator(firstNumber, secondNumber, operator));
        return "index";
    }
}
