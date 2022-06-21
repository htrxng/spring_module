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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
        model.addAttribute("customers",
                this.iCustomerService.findAll(keyWordNameVal, keyWordPhoneVal, customerTypeIdVal, pageable));
        model.addAttribute("keyWordNameVal", keyWordNameVal);
        model.addAttribute("keyWordPhoneVal", keyWordPhoneVal);
        model.addAttribute("customerTypeIdVal", customerTypeIdVal);
//        model.addAttribute("message","Hữu Trung xin chào toàn thể lớp C12 ^^");
        return "/customer/list";
    }

    @GetMapping(value = "/addNewCustomer")
    public String goAddCustomer(Model model) {
        CustomerDto customerDto = new CustomerDto();
        model.addAttribute("customerDto", customerDto);
        return "customer/create";
    }

    @PostMapping(value = "/addCustomerToSystem")
    public String addCustomer(@ModelAttribute @Validated CustomerDto customerDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        new CustomerDto().validate(customerDto,bindingResult);
        if(bindingResult.hasFieldErrors()) {
            return "customer/create";
        } else {
            Customer newCustomer = new Customer();
            BeanUtils.copyProperties(customerDto, newCustomer);
            iCustomerService.save(newCustomer);
            redirectAttributes.addFlashAttribute("message","Customer " +
                    newCustomer.getCustomerName() + " has just been successfully added!");
            return "redirect:/customer/list";
        }
    }
    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute @Validated CustomerDto customerDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        new CustomerDto().validate(customerDto,bindingResult);
        if(bindingResult.hasFieldErrors()) {
            return "customer/edit";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            iCustomerService.save(customer);
            redirectAttributes.addFlashAttribute("message","Customer " +
                    customer.getCustomerName() + " has just been successfully updated!");
            return "redirect:/customer/list";
        }
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
        model.addAttribute("customerDto", customerDto);
        return "/customer/edit";
    }


    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam String id,RedirectAttributes redirectAttributes) {
        this.iCustomerService.deleteById(Integer.parseInt(id));
        redirectAttributes.addFlashAttribute("message","Delete successfully!");
        return "redirect:/customer/list";
    }
    @GetMapping("occ-list")
    public String goOccList(Model model){
        model.addAttribute("occupiedList",this.iCustomerService.findAllOcc());
        return "customer/occ-list";
    }
}
