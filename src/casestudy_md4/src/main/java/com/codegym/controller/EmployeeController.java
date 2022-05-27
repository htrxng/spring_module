package com.codegym.controller;

import com.codegym.dto.EmployeeDto;
import com.codegym.model.employee.Division;
import com.codegym.model.employee.EducationDegree;
import com.codegym.model.employee.Employee;
import com.codegym.model.employee.Position;

import com.codegym.service.employee.IDivisionService;
import com.codegym.service.employee.IEducationDegreeService;
import com.codegym.service.employee.IEmployeeService;
import com.codegym.service.employee.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IEducationDegreeService iEducationDegreeService;
    @Autowired
    private IDivisionService iDivisionService;
    @Autowired
    private IEmployeeService iEmployeeService;

    @ModelAttribute("positionList")
    public List<Position> findAllPosition() {
        return this.iPositionService.findAll();
    }

    @ModelAttribute("educationDegreeList")
    public List<EducationDegree> findAllEducationDegree() {
        return this.iEducationDegreeService.findAll();
    }

    @ModelAttribute("divisionList")
    public List<Division> findAllDivision() {
        return this.iDivisionService.findAll();
    }

    @GetMapping(value = "/list")
    public String showList(Model model,
                           @PageableDefault(value = 3) Pageable pageable,
                           @RequestParam Optional<String> keyWordName,
                           @RequestParam Optional<String> positionId,
                           @RequestParam Optional<String> divisionId) {
        String keyWordNameVal = keyWordName.orElse("");
        String positionIdVal = positionId.orElse("%");
        String divisionIdVal = divisionId.orElse("%");
        model.addAttribute("employees", this.iEmployeeService.findAllPaging
                (keyWordNameVal, positionIdVal, divisionIdVal, pageable));
        model.addAttribute("keyWordNameVal", keyWordNameVal);
        model.addAttribute("positionIdVal", positionIdVal);
        model.addAttribute("divisionIdVal", divisionIdVal);
        return "/employee/list";
    }

    @GetMapping(value = "/addNewEmployee")
    public String goAddEmployee(Model model) {
        EmployeeDto employeeDto = new EmployeeDto();
        model.addAttribute("employeeDto", employeeDto);
        return "employee/create";
    }

    @PostMapping(value = "/addEmployeeToSystem")
    public String addCustomer(@ModelAttribute @Validated EmployeeDto employeeDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        new EmployeeDto().validate(employeeDto,bindingResult);
        if(bindingResult.hasFieldErrors()) {
            return "employee/create";
        } else {
            Employee employee = new Employee();
            employee.setEmployeeSalary(Double.parseDouble(employeeDto.getEmployeeSalary()));
            BeanUtils.copyProperties(employeeDto, employee);
            iEmployeeService.save(employee);
            return "redirect:/employee/list";
        }
    }

    @GetMapping("/detailForm")
    public String goDetail(@RequestParam String id, Model model) {
        model.addAttribute("employee", this.iEmployeeService.findById(Integer.parseInt(id)));
        return "/employee/detail";
    }

    @GetMapping("/editForm")
    public String goEditForm(@RequestParam String id, Model model) {
        EmployeeDto employeeDto = new EmployeeDto();
        Employee employee = this.iEmployeeService.findById(Integer.parseInt(id));
        BeanUtils.copyProperties(employee, employeeDto);
        employeeDto.setEmployeeSalary(String.valueOf(employee.getEmployeeSalary()));
        model.addAttribute("employeeDto", employeeDto);
        return "/employee/edit";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute @Validated  EmployeeDto employeeDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        new EmployeeDto().validate(employeeDto,bindingResult);
        if(bindingResult.hasFieldErrors()) {
            return "/employee/edit";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employee.setEmployeeSalary(Double.parseDouble(employeeDto.getEmployeeSalary()));
            iEmployeeService.save(employee);
            return "redirect:/employee/list";
        }
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam String id) {
        this.iEmployeeService.deleteById(Integer.parseInt(id));
        return "redirect:/employee/list";
    }
}
