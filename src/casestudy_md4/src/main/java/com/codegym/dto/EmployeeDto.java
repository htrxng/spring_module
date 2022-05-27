package com.codegym.dto;

import com.codegym.model.employee.Division;
import com.codegym.model.employee.EducationDegree;
import com.codegym.model.employee.Position;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class EmployeeDto implements Validator {
    private Integer employeeId;
    @NotBlank(message = "Name must be not blank")
    private String employeeName;
    private String employeeDateOfBirth;
    @NotBlank(message = "this information must be not blank")
    private String employeeIdCard;
    @Pattern(regexp = "[+]?\\d*\\.?\\d*",message = "Cost must be a number.")
    private String employeeSalary;
    private String employeePhone;
    @Email
    private String employeeEmail;
    private String employeeAddress;
    private Position position;
    private EducationDegree educationDegree;
    private Division division;

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        if(!employeeDto.getEmployeePhone().matches("((\\(84\\)\\+(90))|(\\(84\\)\\+(91))|(090)|(091))\\d{7}")) {
            errors.rejectValue("employeePhone","phone.forbidden","An unknown error");
        }
        if(!employeeDto.getEmployeeEmail().matches("([a-z]\\w+@[a-z]{2,}\\.)\\w{2,10}(\\.\\w{2,3})?")) {
            errors.rejectValue("employeeEmail","email.forbidden","An unknown error");
        }
        if(!employeeDto.getEmployeeIdCard().matches("\\d{9}|\\d{12}")) {
            errors.rejectValue("employeeIdCard","idCard.forbidden","An unknown error");
        }
        if(employeeDto.position == null) {
            errors.rejectValue("position","position.forbidden","An unknown error");
        }
        if(employeeDto.educationDegree == null) {
            errors.rejectValue("educationDegree","educationDegree.forbidden","An unknown error");
        }
        if(employeeDto.division == null) {
            errors.rejectValue("division","division.forbidden","An unknown error");
        }
    }
    public EmployeeDto() {
    }

    public EmployeeDto(Integer employeeId, @NotBlank(message = "Name must be not blank") String employeeName, String employeeDateOfBirth, @NotBlank(message = "this information must be not blank") String employeeIdCard, @Pattern(regexp = "[+]?\\d*\\.?\\d*", message = "Cost must be a number.") String employeeSalary, String employeePhone, @Email String employeeEmail, String employeeAddress, Position position, EducationDegree educationDegree, Division division) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeDateOfBirth = employeeDateOfBirth;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeDateOfBirth() {
        return employeeDateOfBirth;
    }

    public void setEmployeeDateOfBirth(String employeeDateOfBirth) {
        this.employeeDateOfBirth = employeeDateOfBirth;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


}
