package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> displayList() {
        return this.iProductRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return this.iProductRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return this.iProductRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        this.iProductRepository.delete(findById(id));
    }

    @Override
    public Page<Product> findAllByNameContaining(String name, Pageable pageable) {
        return iProductRepository.findAllByNameContaining(name,pageable);
    }
}
