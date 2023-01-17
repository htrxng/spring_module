package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping(value = "/blogRest")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/blogs")
    public ResponseEntity<Page<Blog>> getPageBlog(
            @PageableDefault(value = 4) Pageable pageable) {
        Page<Blog> blogPage = this.iBlogService.findAllPaging(pageable);
        if (!blogPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> getViewBlog(@PathVariable Integer id) {
        Blog blog = this.iBlogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }


}
