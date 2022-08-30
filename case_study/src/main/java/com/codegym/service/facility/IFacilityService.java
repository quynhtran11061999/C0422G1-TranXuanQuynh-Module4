package com.codegym.service.facility;

import com.codegym.model.facility.Facility;

import java.util.List;

public interface IFacilityService {

    List<Facility> findAll();

    Facility findById(int id);

    void save(Facility facility);

    void delete(int id);
}
