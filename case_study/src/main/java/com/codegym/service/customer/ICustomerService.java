package com.codegym.service.customer;

import com.codegym.model.customer.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer book);

    void delete(int id);
}
