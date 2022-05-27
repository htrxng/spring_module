package com.codegym.controller;

import com.codegym.dto.FacilityDto;
import com.codegym.model.facility.FacilityType;
import com.codegym.model.facility.RentType;
import com.codegym.model.facility.Facility;
import com.codegym.service.facility.IFacilityTypeService;
import com.codegym.service.facility.IRentTypeService;
import com.codegym.service.facility.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/facility")
public class FacilityController {
    @Autowired
    private IFacilityTypeService iFacilityTypeService;
    @Autowired
    private IRentTypeService iRentTypeService;
    @Autowired
    private IFacilityService iFacilityService;

    @ModelAttribute("facilityList")
    public List<FacilityType> findAllFacilityType() {
        return this.iFacilityTypeService.findAll();
    }
    @ModelAttribute("rentTypeList")
    public List<RentType> findAllRentType() {
        return this.iRentTypeService.findAll();
    }

    @GetMapping(value = "/addNewFacility")
    public String goAddService(Model model) {
        FacilityDto facilityDto = new FacilityDto();
        model.addAttribute("facilityDto", facilityDto);
        return "service/create";
    }
    @PostMapping(value = "/addFacility")
    public String addService(@ModelAttribute @Validated FacilityDto facilityDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        new FacilityDto().validate(facilityDto,bindingResult);
        if(bindingResult.hasFieldErrors()) {
            return "service/create";
        } else {
            Facility facility =   new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            iFacilityService.save(facility);
            redirectAttributes.addFlashAttribute("message","Add Facility successfully!");
            return "redirect:/facility/addNewFacility";
        }

    }
}
