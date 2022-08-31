package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    public List<Blog> findAll() {
        return this.iBlogRepository.findAll();
    }

    @Override
    public Blog save(Blog blog) {
        return this.iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return this.iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        this.iBlogRepository.delete(findById(id));
    }

    @Override
    public Page<Blog> findAllByTitleContaining(String title, Pageable pageable) {
        return iBlogRepository.findAllByTitleContaining(title, pageable);
    }

    @Override
    public List<Blog> findByCategoryId(Integer id) {
        return iBlogRepository.findByCategoryId(id);
    }

}
