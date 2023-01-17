package com.codegym.controller;

import com.codegym.model.Condiment;
import com.codegym.service.ICondimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SandwichCondimentController {
    @Autowired
    private ICondimentService iCondimentService;

    @GetMapping("/")
    public String goIndex(Model model) {
        List<Condiment> condiments = iCondimentService.getCondimentList();
        model.addAttribute("condiments",condiments);
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam("condimentSelected") String[] condimentSelected, Model model) {
        List<Condiment> condiments = iCondimentService.getCondimentList();
        model.addAttribute("condiments",condiments);
        model.addAttribute("condiments",condimentSelected);
        return "results";
    }
}
