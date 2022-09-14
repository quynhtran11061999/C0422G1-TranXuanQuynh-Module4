package com.codegym.service.contract;

import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<Contract> findAllByEndDayContaining(String endDay, Pageable pageable);

    void save(Contract contract);

//    void saveContractDetail(ContractDetail contractDetail);

}
