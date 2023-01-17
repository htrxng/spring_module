package com.codegym.controller;

//import org.springframework.stereotype.Controller;

import com.codegym.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ConvertMoneyController {
    @Autowired
    private IConvertService convertService;

    @GetMapping(value = "/convert/{money}/{rate}")
    public String convertMoney(@PathVariable double money, @PathVariable double rate, Model model) {
        double result = convertService.convertMoney(money,rate);
        model.addAttribute("result", result);
        return "convert";
    }

    @GetMapping(value = "/homePage")
    public String doPost(Model model) {
        model.addAttribute("resultFlag", false);
        return "convert";
    }
}
