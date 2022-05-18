package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void deleteById(Integer id) {
        iBlogRepository.deleteById(id);
    }

//    @Override
//    public List<Blog> findAllBlogByTitle(String keyword) {
//        keyword = "%" + keyword + "%";
//        return iBlogRepository.findAllByTitle(keyword);
//    }

    @Override
    public Page<Blog> findAllByPage(String keywordVal, org.springframework.data.domain.Pageable pageable) {
        return iBlogRepository.findAllByTitleBlogContaining(keywordVal,pageable);
    }

    @Override
    public Page<Blog> findAllBlogByTitleAndCategoryAndPage(String keywordVal, Category category, Pageable pageable) {
        return iBlogRepository.findAllByTitleBlogContainingAndCategory_CategoryId(keywordVal,category.getCategoryId(),pageable);
    }

    @Override
    public Page<Blog> findAllPaging(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findAllBLogByCategory_CategoryId(Integer id) {
        return iBlogRepository.findAllByCategory_CategoryId(id);
    }



}
