package com.codegym.repository;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value = "select * from blog where title_blog like :key_word",nativeQuery = true)
    List<Blog> findAllByTitle(@Param("key_word") String name);

    Page<Blog> findAllByTitleBlogContaining(String page, Pageable pagebale);

    Page<Blog> findAllByTitleBlogContainingAndCategory_CategoryId(String titleBlog, Integer categoryId, Pageable pageable);

    List<Blog> findAllByCategory_CategoryId(Integer id);
}
