package com.codegym.service;

import com.codegym.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPhoneService {
    Page<Phone> findAll(Pageable pageable);

    Phone save(Phone phone);

    Phone findById(int id);

    void delete(int id);
}
