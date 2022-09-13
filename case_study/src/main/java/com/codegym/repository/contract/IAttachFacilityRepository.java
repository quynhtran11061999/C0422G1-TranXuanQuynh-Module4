package com.codegym.repository.contract;

import com.codegym.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility, Integer> {
    AttachFacility findAllByContractDetails_IdContractDetail(Integer id);
}
