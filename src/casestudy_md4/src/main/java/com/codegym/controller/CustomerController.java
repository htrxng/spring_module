package com.codegym.controller;

import com.codegym.model.CustomerType;
import com.codegym.service.ICustomerService;
import com.codegym.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private ICustomerTypeService iCustomerTypeService;
    @Autowired
    private ICustomerService iCustomerService;

    @ModelAttribute("customerTypeList")
    public List<CustomerType> findAllCustomerType() {
        return this.iCustomerTypeService.findAll();
    }

    @GetMapping(value = "/list")
    public String showList(Model model,
                           @PageableDefault(value = 3)Pageable pageable,
                           @RequestParam Optional<String> keyWord) {
        String keywordVal = keyWord.orElse("");
//        model.addAttribute("customers", this.iCustomerService.findAllByPage(keywordVal, pageable));
        model.addAttribute("customers",this.iCustomerService.findAll(pageable));
//        System.out.println(this.iCustomerService.findAll(pageable));
        return "/customer/list";
    }
}
