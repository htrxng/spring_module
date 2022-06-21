package com.codegym.controller;

import com.codegym.dto.ProductOrderDto;
import com.codegym.model.Product;
import com.codegym.model.ProductOrder;
import com.codegym.model.ProductType;
import com.codegym.service.IProductOrderService;
import com.codegym.service.IProductService;
import com.codegym.service.IProductTypeService;
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

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class ProductOrderController {
    @Autowired
    private IProductOrderService iProductOrderService;
    @Autowired
    private IProductTypeService iProductTypeService;
    @Autowired
    private IProductService iProductService;

    @ModelAttribute("productTypeList")
    public List<ProductType> findAllProductType() {
        return this.iProductTypeService.findAll();
    }
    @ModelAttribute("productList")
    public List<Product> findAllProduct() {
        return this.iProductService.findAll();
    }

    @GetMapping(value = "/list")
    public String showOrderList(Model model,
                                @PageableDefault(value = 3)Pageable pageable) {
        model.addAttribute("orderList", iProductOrderService.findAll(pageable));
        return "list";
    }

    @GetMapping("/editForm")
    public String goEditForm(@RequestParam String id, Model model) {
        ProductOrderDto productOrderDto = new ProductOrderDto();
        BeanUtils.copyProperties(this.iProductOrderService.findById(Integer.parseInt(id)), productOrderDto);
        model.addAttribute("productOrderDto", productOrderDto);
        return "/edit";
    }

    @PostMapping("/update")
    public String updateOrder(@ModelAttribute @Validated ProductOrderDto productOrderDto,
                                 BindingResult bindingResult) {
        new ProductOrderDto().validate(productOrderDto,bindingResult);
        if(bindingResult.hasFieldErrors()) {
            return "/edit";
        } else {
            ProductOrder productOrder = new ProductOrder();
            BeanUtils.copyProperties(productOrderDto, productOrder);
            productOrder.setQuantity(Integer.parseInt(productOrderDto.getQuantity()));
            iProductOrderService.save(productOrder);
            return "redirect:/order/list";
        }
    }


}
