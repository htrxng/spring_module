package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findById(Integer id);
    void save(Blog blog);
    void deleteById(Integer id);

}
