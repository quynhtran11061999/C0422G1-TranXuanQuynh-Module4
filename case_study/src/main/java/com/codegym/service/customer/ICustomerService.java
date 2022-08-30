package com.codegym.service.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer book);

    void delete(int id);

    Page<Customer> findAllByNameContaining(String name, Pageable pageable);
}
