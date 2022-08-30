package com.codegym.service.facility.impl;

import com.codegym.model.customer.Customer;
import com.codegym.model.facility.Facility;
import com.codegym.repository.facility.IFacilityRepository;
import com.codegym.service.facility.IFacilityService;
import com.codegym.service.facility.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public List<Facility> findAll() {
        return this.iFacilityRepository.findAll();
    }

    @Override
    public Facility findById(int id) {
        return this.iFacilityRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Facility facility) {
        this.iFacilityRepository.save(facility);
    }

    @Override
    public void delete(int id) {
        this.iFacilityRepository.delete(findById(id));
    }
}
