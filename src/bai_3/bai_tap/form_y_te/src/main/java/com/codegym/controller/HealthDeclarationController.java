package com.codegym.controller;

import com.codegym.model.HealthDeclarationForm;
import com.codegym.service.IHealthDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HealthDeclarationController {
    @Autowired
    IHealthDeclarationService IHealthDeclarationService;

    @GetMapping("/create")
    public String goCreate(Model model) {
        model.addAttribute("healthForm",new HealthDeclarationForm());
        return "create";
    }
    @PostMapping("declare")
    public String declare(@ModelAttribute HealthDeclarationForm healthDeclarationForm, Model model) {
        this.IHealthDeclarationService.saveUpdate(healthDeclarationForm);
        model.addAttribute("healthDeclarationForm",healthDeclarationForm);
        return "view";
    }
    @PostMapping("update")
    public String update(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("healthDeclarationForm",this.IHealthDeclarationService.getHealDeclarationForm());
        return "redirect:/create";
    }

}