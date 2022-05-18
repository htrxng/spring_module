package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findById(Integer id);
    void save(Blog blog);
    void deleteById(Integer id);

//    List<Blog> findAllBlogByTitle(String keyword);


    Page<Blog> findAllByPage(String keywordVal, Pageable pageable);

//    Li findAllBlogByTitleAndCategory(String keyword, Category category);

    Page<Blog> findAllBlogByTitleAndCategoryAndPage(String keywordVal, Category category, Pageable pageable);

    Page<Blog> findAllPaging(Pageable pageable);

    List<Blog> findAllBLogByCategory_CategoryId(Integer id);
}
