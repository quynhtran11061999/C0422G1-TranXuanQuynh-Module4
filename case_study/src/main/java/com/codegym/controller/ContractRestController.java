package com.codegym.controller;

import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.ContractDetail;
import com.codegym.service.contract.IAttachFacilityService;
import com.codegym.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/contractRest")
public class ContractRestController {
    @Autowired
    private IAttachFacilityService attachFacilityService;

    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping(value = "/attachFacility")
    public ResponseEntity<List<ContractDetail>> getAttachFacility(@RequestParam Integer id) throws Exception {
    List<ContractDetail> contractDetailList = contractDetailService.findAllByContractId(id);
        return new ResponseEntity<>(contractDetailList, HttpStatus.OK);
    }
}
