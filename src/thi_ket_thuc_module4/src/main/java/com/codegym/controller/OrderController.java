package com.codegym.controller;

import com.codegym.service.IOrderService;
import com.codegym.service.IProductService;
import com.codegym.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Pageable;
import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private IOrderService iOrderService;

    @Autowired
    private IProductTypeService iProductTypeService;

    @Autowired
    private IProductService iProductService;


    @GetMapping(value = "/list")
    public String showOrderList(Model model,
                                @PageableDefault(value = 3)Pageable pageable) {
        model.addAttribute("orderList",
                this.iOrderService.findAll(pageable));
        return "/list";
    }

}
