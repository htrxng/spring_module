package com.codegym.dto;

import com.codegym.model.facility.FacilityType;
import com.codegym.model.facility.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class FacilityDto implements Validator {
    private Integer facilityId;
    @NotBlank(message = "this information must be not blank")
    private String facilityCode;
    @NotBlank(message = "this information must be not blank")
    private String facilityName;
    @NotBlank(message = "this information must be not blank")
    @Pattern(regexp = "[+]?\\d*\\.?\\d*",message = "Area must be a number.")
    private String facilityArea;
    @NotBlank(message = "this information must be not blank")
    @Pattern(regexp = "[+]?\\d*\\.?\\d*",message = "Cost must be a number.")
    private String facilityCost;
    @NotBlank(message = "this information must be not blank")
    @Pattern(regexp = "[+]?[\\d.]+",message = "This information must be a number.")
    private String facilityMaxPeople;
    @NotBlank(message = "this information must be not blank")
    private String standardRoom;
    private String descriptionOtherConvenience;
    @Pattern(regexp = "[+]?\\d*\\.?\\d*",message = "Pool Area must be a number.")
    private String poolArea;
    @Pattern(regexp = "[+]?\\d*\\.?\\d*" ,message = "this information must be an integer.")
    private String numberOfFloors;
    private FacilityType facilityType;
    private RentType rentType;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;
        if(!facilityDto.getFacilityCode().matches("DV-\\d{4}")) {
            errors.rejectValue("facilityCode","facilityCode.forbidden","An unknown error");
        }
        if(facilityDto.getFacilityType() == null) {
            errors.rejectValue("facilityType","facilityType.forbidden","An unknown error");
        }
        if(facilityDto.getRentType() == null) {
            errors.rejectValue("rentType","rentType.forbidden","An unknown error");
        }
    }

    public FacilityDto() {
    }

    public FacilityDto(Integer facilityId, @NotBlank(message = "this information must be not blank") String facilityCode, @NotBlank(message = "this information must be not blank") String facilityName, @NotBlank(message = "this information must be not blank") String facilityArea, @NotBlank(message = "this information must be not blank") String facilityCost, @NotBlank(message = "this information must be not blank") String facilityMaxPeople, @NotBlank(message = "this information must be not blank") String standardRoom, String descriptionOtherConvenience, String poolArea, String numberOfFloors, FacilityType facilityType, RentType rentType) {
        this.facilityId = facilityId;
        this.facilityCode = facilityCode;
        this.facilityName = facilityName;
        this.facilityArea = facilityArea;
        this.facilityCost = facilityCost;
        this.facilityMaxPeople = facilityMaxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityType = facilityType;
        this.rentType = rentType;
    }

    public Integer getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Integer facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityCode() {
        return facilityCode;
    }

    public void setFacilityCode(String facilityCode) {
        this.facilityCode = facilityCode;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityArea() {
        return facilityArea;
    }

    public void setFacilityArea(String facilityArea) {
        this.facilityArea = facilityArea;
    }

    public String getFacilityCost() {
        return facilityCost;
    }

    public void setFacilityCost(String facilityCost) {
        this.facilityCost = facilityCost;
    }

    public String getFacilityMaxPeople() {
        return facilityMaxPeople;
    }

    public void setFacilityMaxPeople(String facilityMaxPeople) {
        this.facilityMaxPeople = facilityMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }
}
