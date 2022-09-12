package com.codegym.controller;

import com.codegym.model.contract.ContractDetail;
import com.codegym.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/restContractDetail")
public class ContractDetailController {
    @Autowired
    private IContractDetailService iContractDetailService;

    @GetMapping("/{id}")
    public ResponseEntity<List<ContractDetail>> getContractDetail(@PathVariable Integer id){
        List<ContractDetail> contractDetailList = this.iContractDetailService.findAllByContractId(id);
        if (contractDetailList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
