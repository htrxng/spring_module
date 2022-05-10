package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping(value = "/list")
    public String showList(Model model){
        model.addAttribute("blogList",this.iBlogService.findAll());
        return "/list";
    }

    @GetMapping(value = "/upload")
    public String goCreate(Model model) {
        model.addAttribute("blog",new Blog());
        return "/create";
    }

    @PostMapping(value = "/uploadToWeb")
    public String uploadToWeb(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("success","add successfully!");
        return "redirect:/list";
    }

    @GetMapping("/{id}/editForm")
    public String goEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("blog",this.iBlogService.findById(id));
        return "edit";
    }
    @PostMapping(value = "/update")
    public String update(Blog blog) {
        iBlogService.save(blog);
        return "redirect:/list";
    }
    @GetMapping("{id}/deleteForm")
    public String goDelete(@PathVariable Integer id, Model model) {
        model.addAttribute("blog",this.iBlogService.findById(id));
        return "delete";
    }
    @PostMapping(value = "/delete")
    public String delete(Blog blog,RedirectAttributes redirectAttributes) {
        iBlogService.deleteById(blog.getBlogId());
        redirectAttributes.addFlashAttribute("success","delete successfully!");
        return "redirect:/list";
    }
    @GetMapping("/{id}/detailForm")
    public String goDetail(@PathVariable Integer id,Model model) {
        model.addAttribute("blog",iBlogService.findById(id));
        return "detail";
    }
}





















