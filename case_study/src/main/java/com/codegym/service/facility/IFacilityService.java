package com.codegym.service.facility;

import com.codegym.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {

    List<Facility> findAll();

    Facility findById(int id);

    void save(Facility facility);

    void delete(int id);

    Page<Facility> findAllByNameContaining(String name, Pageable pageable);
}
