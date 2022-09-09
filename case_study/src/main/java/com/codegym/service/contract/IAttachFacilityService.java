package com.codegym.service.contract;

import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.ContractDetail;

import java.util.List;

public interface IAttachFacilityService {
    AttachFacility findByContractDetailId(Integer contractDetailId);
}
