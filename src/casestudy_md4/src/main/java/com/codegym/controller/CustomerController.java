package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
                           @PageableDefault(value = 3) Pageable pageable,
                           @RequestParam Optional<String> keyWordName,
                           @RequestParam Optional<String> keyWordPhone,
                           @RequestParam Optional<Integer> customerTypeId) {
        String keyWordNameVal = keyWordName.orElse("");
        String keyWordPhoneVal = keyWordPhone.orElse("");
        Integer customerTypeIdVal = customerTypeId.orElse(-1);
        model.addAttribute("customers", this.iCustomerService.findAll(keyWordNameVal, keyWordPhoneVal, customerTypeIdVal, pageable));
        model.addAttribute("keyWordNameVal", keyWordNameVal);
        model.addAttribute("keyWordPhoneVal", keyWordPhoneVal);
        model.addAttribute("customerTypeIdVal", customerTypeIdVal);
        return "/customer/list";
    }

    @GetMapping(value = "/addNewCustomer")
    public String goAddCustomer(Model model) {
        CustomerDto customerDto = new CustomerDto();
        model.addAttribute("customer", customerDto);
        return "customer/create";
    }

    @PostMapping(value = "/addCustomerToSystem")
    public String addCustomer(@ModelAttribute CustomerDto customerDto, RedirectAttributes redirectAttributes) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.save(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/detailForm")
    public String goDetail(@RequestParam String id, Model model) {
        model.addAttribute("customer", this.iCustomerService.findById(Integer.parseInt(id)));
        return "/customer/detail";
    }

    @GetMapping("/editForm")
    public String goEditForm(@RequestParam String id, Model model) {
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(this.iCustomerService.findById(Integer.parseInt(id)), customerDto);
        model.addAttribute("customer", customerDto);
        return "/customer/edit";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute CustomerDto customerDto, RedirectAttributes redirectAttributes) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.save(customer);
        return "redirect:/customer/list";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam String id) {
        this.iCustomerService.deleteById(Integer.parseInt(id));
        return "redirect:/customer/list";
    }

}
