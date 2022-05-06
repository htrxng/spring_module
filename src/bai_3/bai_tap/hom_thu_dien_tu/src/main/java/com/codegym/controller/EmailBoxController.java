package com.codegym.controller;

import com.codegym.model.EmailBox;
import com.codegym.service.IEmailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailBoxController {
    @Autowired
    IEmailBoxService iEmailBoxService;

    @GetMapping(value = "/home")
    public String home(Model model) {

        model.addAttribute("emailBox", new EmailBox());

        return "home";
    }

    @PostMapping(value = "update")
    public String updateEmailBox(@ModelAttribute EmailBox emailBox,
                                 RedirectAttributes redirectAttributes) {
        iEmailBoxService.update(emailBox);
        return "home";
    }

}
