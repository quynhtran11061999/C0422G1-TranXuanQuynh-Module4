package com.codegym.controller;

import com.codegym.dto.ContractDto;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.facility.Facility;
import com.codegym.service.contract.IContractService;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.employee.IEmployeeService;
import com.codegym.service.facility.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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

    @GetMapping("/showAdd")
    public String showAdd(Model model){
            model.addAttribute("contractDto",new Contract());
            model.addAttribute("customer",this.iCustomerService.findAll());
            model.addAttribute("facility",this.iFacilityService.findAll());
            model.addAttribute("employee",this.iEmployeeService.findAll());
            return "/contract/add";
    }

    @PostMapping("/createContract")
    public String createContract(@ModelAttribute @Valid ContractDto contractDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes rd) {
        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasErrors()){
            return "redirect:/contract/list";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);

        Facility facility = new Facility();
        facility.setIdService(contractDto.getFacility().getIdService());
        contract.setFacility(facility);

        Customer customer = new Customer();
        customer.setId(contractDto.getCustomer().getId());
        contract.setCustomer(customer);

        Employee employee = new Employee();
        employee.setIdEmployee(contractDto.getEmployee().getIdEmployee());
        contract.setEmployee(employee);

        iContractService.save(contract);
        rd.addFlashAttribute("msg", "Thêm mới hợp đồng thành công");
        return "redirect:/contract/list";
    }
}
