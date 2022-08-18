package com.product_management.service;

import com.product_management.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> displayList();

    void add(Product product);

    Product findById(int id);

    void update(int id,Product product);

    void delete(int id);

    List<Product> searchByName(String name);
}
