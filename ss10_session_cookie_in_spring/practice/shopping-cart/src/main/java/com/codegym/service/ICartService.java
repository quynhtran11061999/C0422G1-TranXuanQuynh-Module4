package com.codegym.service;

import com.codegym.model.Product;

import java.util.Map;

public interface ICartService {
    double getTotal(Map<Product,Integer> cart);
}
