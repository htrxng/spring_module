package com.codegym.controller;

import com.codegym.dto.TransactionDto;
import com.codegym.model.Customer;
import com.codegym.model.Transaction;
import com.codegym.service.ICustomerService;
import com.codegym.service.ITransactionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/transaction")
public class TransactionController {
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    ITransactionService iTransactionService;

    @ModelAttribute("customerList")
    public List<Customer> findAllCustomer() {
        return this.iCustomerService.findAll();
    }

    @GetMapping(value = "/list")
    public String goList(Model model,
                         @RequestParam Optional<String> keyWordServiceType,
                         @RequestParam Optional<Integer> customerId) {
        String keyWordServiceTypeVal = keyWordServiceType.orElse("");
        Integer customerIdVal = customerId.orElse(-1);
        List<Transaction> transactionList =  iTransactionService.findAll(keyWordServiceTypeVal,customerIdVal);
            model.addAttribute("transactionList", transactionList);
            return "/transaction/list";
    }

    @GetMapping(value = "/addNewTransaction")
    public String goAddTransaction(Model model) {
        TransactionDto transactionDto = new TransactionDto();
        model.addAttribute("transactionDto", transactionDto);
        return "/transaction/create";
    }

    @PostMapping(value = "/addNewTransaction")
    public String doAddTransaction(@ModelAttribute @Validated TransactionDto transactionDto,
                                   BindingResult bindingResult) {
        new TransactionDto().validate(transactionDto,bindingResult);
        if(bindingResult.hasFieldErrors()) {
            return "transaction/create";
        } else {
            Transaction transaction = new Transaction();
            BeanUtils.copyProperties(transactionDto,transaction);
            transaction.setArea(Double.parseDouble(transactionDto.getArea()));
            transaction.setBill(Double.parseDouble(transactionDto.getBill()));
            iTransactionService.save(transaction);
            return "redirect:/transaction/list";
        }

    }
    @GetMapping(value = "/detailForm")
    public String goDetailTransaction(@RequestParam String id, Model model) {
        model.addAttribute("transaction",
                this.iTransactionService.findById(Integer.parseInt(id)));
        return "transaction/detail";
    }
    @PostMapping(value = "/delete")
    public String deleteTransaction(@RequestParam String id) {
        this.iTransactionService.deleteById(Integer.parseInt(id));
        return "redirect:/transaction/list";
    }
}
