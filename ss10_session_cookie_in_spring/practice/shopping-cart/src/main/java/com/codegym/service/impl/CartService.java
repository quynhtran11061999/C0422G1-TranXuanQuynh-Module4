package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.service.ICartService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartService implements ICartService {
    @Override
    public double getTotal(Map<Product, Integer> cart) {
        double total = 0;
        for (Product p : cart.keySet()){
            total += p.getPrice()*cart.get(p);
        }
        return total;
    }
}
