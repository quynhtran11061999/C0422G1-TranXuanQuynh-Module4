package com.codegym.service.facility;

import com.codegym.model.customer.CustomerType;
import com.codegym.model.facility.FacilityType;

import java.util.List;

public interface IFacilityTypeService {
    List<FacilityType> findAll();
}
