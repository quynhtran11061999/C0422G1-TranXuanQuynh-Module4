package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return this.iProductRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return iProductRepository.findById(id).orElse(null);
    }
}