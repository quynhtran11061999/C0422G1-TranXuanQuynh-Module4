package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    Blog save(Blog blog);

    Blog findById(int id);

    void delete(int id);

    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);

    List<Blog> findByCategoryId(Integer id);
}
