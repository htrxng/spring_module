package com.codegym.controller;

import com.codegym.dto.ContractDetailDto;
import com.codegym.dto.ContractDto;
import com.codegym.model.contract.AttachService;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.facility.Facility;
import com.codegym.service.contract.IAttachServiceService;
import com.codegym.service.contract.IContractDetailService;
import com.codegym.service.contract.IContractService;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.employee.IEmployeeService;
import com.codegym.service.facility.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;
    @Autowired
    private IContractDetailService iContractDetailService;
    @Autowired
    private IAttachServiceService iAttachServiceService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IFacilityService iFacilityService;

    @ModelAttribute("attachServiceList")
    public List<AttachService> findAllAttachService() {
        return this.iAttachServiceService.findAll();
    }

    @ModelAttribute("customerList")
    public List<Customer> findAllCustomer() {
        return this.iCustomerService.findAllCustomer();
    }
    @ModelAttribute("employeeList")
    public List<Employee> findAllEmployee() {
        return this.iEmployeeService.findAll();
    }
    @ModelAttribute("facilityList")
    public List<Facility> findAllFacility() {
        return this.iFacilityService.findAll();
    }

    @ModelAttribute("contractDetailList")
    public List<ContractDetail> findAllContractDetail() {
        return this.iContractDetailService.findAll();
    }

    @GetMapping(value = "/list")
    public String showList(Model model) {
        model.addAttribute("contractList",this.iContractService.findAll());
        return "/contract/list";
    }

    @GetMapping(value = "/addNewContract")
    public String goAddContract(Model model) {
        ContractDto contractDto = new ContractDto();
        model.addAttribute("contractDto",contractDto);
        return "contract/create";
    }
    @PostMapping(value = "/addContractToSystem")
    public String addContract(@ModelAttribute @Validated ContractDto contractDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        new ContractDto().validate(contractDto,bindingResult);
        if(bindingResult.hasFieldErrors()) {
            return "contract/create";
        }  else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            contract.setContractDeposit(Double.valueOf(contractDto.getContractDeposit()));
            contract.setContractTotalMoney(contractDto.getFacility().getFacilityCost());
            iContractService.save(contract);

            return "redirect:/contract/list";
        }
    }

    @GetMapping(value = "/addContractDetail")
    public String addContractDetail(@RequestParam  Integer id, Model model) {
        Contract contract = this.iContractService.findById(id);
        ContractDetailDto contractDetailDto = new ContractDetailDto();
        contractDetailDto.setContract(contract);
        model.addAttribute("contractDetailDto",contractDetailDto);
        return "contract/createContractDetail";
    }
    @PostMapping(value = "/addContractDetail")
    public String addContract(@ModelAttribute ContractDetailDto contractDetailDto,
                              RedirectAttributes redirectAttributes) {
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto,contractDetail);
        iContractDetailService.save(contractDetail);
        return "redirect:/contract/list";
    }
}
