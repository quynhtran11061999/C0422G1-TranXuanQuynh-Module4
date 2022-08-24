package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<Product> displayList();

    Product save(Product product);

    Product findById(int id);

    void delete(int id);

    Page<Product> findAllByNameContaining(String name, Pageable pageable);
}
