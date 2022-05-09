package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }


    @GetMapping(value = "/list")
    public String goList(Model model) {
        model.addAttribute("productList",this.iProductService.getProductList());
        return "list";
    }

    @GetMapping(value = "/create")
    public String goCreate(Model model) {
        model.addAttribute("product",new Product());
        return "create";
    }

    @PostMapping(value = "addToList")
    public String addToList(Product product, RedirectAttributes redirectAttributes) {
        iProductService.addProduct(product);
        redirectAttributes.addFlashAttribute("success","add successfully!");
        return "redirect:/list";
    }

    @GetMapping("/{id}/deleteForm")
    public String goDelete(@PathVariable int id,Model model) {
        model.addAttribute("product",this.iProductService.findById(id));
        return "delete";
    }

    @PostMapping(value = "delete")
    public String delete(Product product,RedirectAttributes redirectAttributes){
     iProductService.remove(product.getProductId());
     redirectAttributes.addFlashAttribute("success","delete successfully!");
     return "redirect:/list";
    }

    @GetMapping("/{id}/editForm")
    public String goEdit(@PathVariable int id,Model model) {
        model.addAttribute("product",iProductService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Product product) {
        iProductService.update(product.getProductId(),product);
        return "redirect:/list";
    }

    @GetMapping("/{id}/detailForm")
    public String goDetail(@PathVariable int id,Model model){
        model.addAttribute("product",iProductService.findById(id));
        return "detail";
    }

    @GetMapping("search")
    public String search(@RequestParam String query,Model model) {
        model.addAttribute("productList",iProductService.findAllByQuery(query));
        System.out.println(iProductService.findAllByQuery(query));
        return "list";
    }
}
