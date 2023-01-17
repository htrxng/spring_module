package com.codegym.controller;


import com.codegym.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CalculatorController {
    @Autowired
    ICalculatorService iCalculatorService;

    @GetMapping("/")
    public String goIndex(Model model, RedirectAttributes redirectAttributes) {
        System.out.println(model.getAttribute("results"));
        return "index";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam("firstNumber") Integer firstNumber,
                            @RequestParam("secondNumber") Integer secondNumber,
                            @RequestParam("operator") String operator,
                            Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("results", this.iCalculatorService.calcutator(firstNumber, secondNumber, operator));
        model.addAttribute("results2", this.iCalculatorService.calcutator(firstNumber, secondNumber, operator));
        model.addAttribute("results3", this.iCalculatorService.calcutator(firstNumber, secondNumber, operator));
        redirectAttributes.addFlashAttribute("test", "Hello");
        redirectAttributes.addFlashAttribute("results", model);
        return "redirect:/";
    }
}
