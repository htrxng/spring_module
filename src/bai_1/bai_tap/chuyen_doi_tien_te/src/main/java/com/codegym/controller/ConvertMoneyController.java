package com.codegym.controller;

//import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertMoneyController {
    @GetMapping(value = "/convert")
    public String convertMoney(@RequestParam double money, @RequestParam double rate, Model model) {
        double result = money * rate;
        model.addAttribute("result", result);
        return "convert";
    }

    @GetMapping(value = "/homePage")
    public String doPost() {
        return "convert";
    }
}
