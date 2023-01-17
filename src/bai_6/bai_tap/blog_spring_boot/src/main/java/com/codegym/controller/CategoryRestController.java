package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categoryRest")
public class CategoryRestController {
    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getPageCategory() {
        List<Category> categoryList = this.iCategoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(categoryList, HttpStatus.OK);
        }
    }

    @GetMapping("/blogsByCategory/{id}")
    public ResponseEntity<List<Blog>> getBlogInCategory(@PathVariable Integer id) {
        List<Blog> blogPage = this.iBlogService.findAllBLogByCategoryCategoryId(id);
        if (blogPage.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

}
