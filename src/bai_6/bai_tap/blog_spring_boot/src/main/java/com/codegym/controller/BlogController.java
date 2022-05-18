package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
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
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;


    // set thuộc tính findAllCategory cho modelAttribute;
    @ModelAttribute("categoryList")
    public List<Category> findAllCategory(){
        return this.iCategoryService.findAll();
    }

    @GetMapping(value = "/list")
    public String showList(Model model,
                           @PageableDefault(value = 2) Pageable pageable,
                           @RequestParam Optional<String> keyWord
    ) {
        String keywordVal = keyWord.orElse("");

        model.addAttribute("blogList", this.iBlogService.findAllByPage(keywordVal, pageable));
        model.addAttribute("keywordVal", keywordVal);
//        model.addAttribute("categoryList", this.iCategoryService.findAll());
        return "/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("categoryId") String categoryId , Model model,
                         @PageableDefault(value = 2) Pageable pageable,
                         @RequestParam Optional<String> keyWord) {
        String keywordVal = keyWord.orElse("");

        if (!keywordVal.equals("")) {
           Category category =  iCategoryService.findById(Integer.parseInt(categoryId));
            model.addAttribute("keywordVal", keywordVal);
            model.addAttribute("blogList", iBlogService.findAllBlogByTitleAndCategoryAndPage(keywordVal, category,pageable));
        } else {
            model.addAttribute("blogList", this.iBlogService.findAllByPage(keywordVal, pageable));
            model.addAttribute("keywordVal", keywordVal);
        }
        return "/list";
    }

    // chuyển đến trang create blog
    @GetMapping(value = "/upload")
    public String goCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "/blog/create";
    }

    // chuyển đến trang create category
    @GetMapping(value = "/createNewCategory")
    public String goCreateCategory(Model model) {
        model.addAttribute("category", new Category());
        return "/category/create";
    }

    // nhận đối tượng blog, save vào DB
    @PostMapping(value = "/uploadToWeb")
    public String uploadToWeb(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("success", "add successfully!");
        return "redirect:/list";
    }

    // nhận đối tượng category, save vào DB
    @PostMapping(value = "/addCategory")
    public String addCategory(Category category) {
        iCategoryService.save(category);
        return "redirect:/list";
    }


    @GetMapping("/{id}/editForm")
    public String goEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", this.iBlogService.findById(id));
        return "/blog/edit";
    }

    @PostMapping(value = "/update")
    public String update(Blog blog) {
        iBlogService.save(blog);
        return "redirect:/list";
    }

    @GetMapping("{id}/deleteForm")
    public String goDelete(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", this.iBlogService.findById(id));
        return "/blog/delete";
    }

    @PostMapping(value = "/delete")
    public String delete(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.deleteById(blog.getBlogId());
        redirectAttributes.addFlashAttribute("success", "delete successfully!");
        return "redirect:/list";
    }

    @GetMapping("/{id}/detailForm")
    public String goDetail(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "/blog/detail";
    }

}





















