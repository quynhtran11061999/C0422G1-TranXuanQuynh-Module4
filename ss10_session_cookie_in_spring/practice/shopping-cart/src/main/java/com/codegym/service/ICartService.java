package com.codegym.service;

import com.codegym.model.Product;

import java.util.Map;

public interface ICartService {
    void add(Map<Product,Integer> cart, Product product);

    double getTotal(Map<Product,Integer> cart);
}
