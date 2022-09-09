package com.codegym.controller;

import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.ContractDetail;
import com.codegym.service.contract.IAttachFacilityService;
import com.codegym.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/contractRest")
public class ContractRestController {
    @Autowired
    private IAttachFacilityService attachFacilityService;

    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping("/attachFacility")
    public ResponseEntity<List<AttachFacility>> getAttachFacility(@RequestParam Integer id){
        List<ContractDetail> contractDetailList = contractDetailService.findAllByContractId(id);
        List<AttachFacility> attachFacilityList = new ArrayList<>();
        for (ContractDetail c:contractDetailList){
            attachFacilityList.add(this.attachFacilityService.findByContractDetailId(c.getIdContractDetail()));
        }
        return new ResponseEntity<>(attachFacilityList, HttpStatus.OK);
    }
}
