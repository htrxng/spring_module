package com.codegym.controller;

import com.codegym.dto.CartDto;
import com.codegym.dto.ProductDto;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("cart") // khai báo session tên là cart
public class ProductController {
    @Autowired
    private IProductService productService;

    // khởi tạo giá trị mặc định cho session cart
    @ModelAttribute("cart")
    public CartDto setupCart() {
        return new CartDto();
    }

    @GetMapping("/shop")
    public ModelAndView showShop(Model model,
                                 @CookieValue(value = "idProduct",
                                         defaultValue = "-1") Long idProduct) {
        if (idProduct != -1) {
            model.addAttribute("historyProduct", productService.findById(idProduct));
        }
        return new ModelAndView("/shop", "productList", productService.findAll());
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @SessionAttribute("cart") CartDto cart,
                            @RequestParam String action) {
        Product product = productService.findById(id);
        if (product == null) {
            return "/error.404";
        }
        String path = null;
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        cart.addProduct(productDto);
        if (action.equals("cart")) {
            path = "redirect:/cart/shopping-cart";
        } else if (action.equals("list")) {
            path = "redirect:/shop";
        }
        return path;
    }

    @GetMapping("/decrease/{id}")
    public String decreaseQuantity(@PathVariable Long id, @SessionAttribute("cart") CartDto cart, @RequestParam String action) {
        Product product = productService.findById(id);
        if (product == null) {
            return "/error.404";
        }
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        cart.decreaseProduct(productDto);
        return "redirect:/cart/shopping-cart";
    }

    @GetMapping("/{id}/detailForm")
    public String goDetail(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);
        if (product != null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            System.out.println(productDto.getPrice());
            model.addAttribute("product", productDto);
            return "/detail";
        } else {
            return "/error.404";
        }
    }
}