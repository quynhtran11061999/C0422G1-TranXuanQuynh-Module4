package com.codegym.controller;

import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.service.contract.IContractService;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.employee.IEmployeeService;
import com.codegym.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IFacilityService iFacilityService;

        @GetMapping("/list")
    public String goListContract(Model model,
                                 @PageableDefault(size = 5) Pageable pageable,
                                 @RequestParam Optional<String> keyword){
        String keywordValue = keyword.orElse("");

            Map<Integer, Double> map = new HashMap<>();
        Page<Contract> contractPage = this.iContractService.findAllByEndDayContaining(keywordValue,pageable);
        double price ;
        for (Contract contract: contractPage){
            price = 0;
            for (ContractDetail contractDetail : contract.getContractDetails()){
                price+= contractDetail.getAmount()*contractDetail.getAttachFacility().getCost();
            }
            map.put(contract.getIdContract(),price);
        }
        model.addAttribute("total",map);
        model.addAttribute("contractList",
                this.iContractService.findAllByEndDayContaining(keywordValue,pageable));
        model.addAttribute("keywordValue",keywordValue);
            return "contract/list";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Contract contract, RedirectAttributes redirectAttributes){
            this.iContractService.save(contract);
            redirectAttributes.addFlashAttribute("mess","Thêm mới hợp đồng thành công");
        return "contract/list";
    }
}
