package com.codegym.dto;

import lombok.Data;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Data
public class UserDto implements Validator {
    private Integer id;

    @NotBlank(message = "this information must be not blank")
    @Size(min = 5, max = 45, message = "min is 5, max 45 character")
    private String firstName;
    @NotBlank(message = "this information must be not blank")
    @Size(min = 5, max = 45, message = "min is 5, max 45 character")
    private String lastName;
    private String phoneNumber;
    private String age;
    @Email(message = "email is not invalid!")
    private String email;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if("admin".equals(userDto.getFirstName())) {
            errors.rejectValue("firstName","name.forbidden","###");
        }
        if(!userDto.getPhoneNumber().matches("(84|0[3|5|7|8|9])+([0-9]{8})\\b")){
            errors.rejectValue("phoneNumber","phone.forbidden","###");
        }
        if ("".equals(userDto.getAge())) {
            errors.rejectValue("age", "date.null", "nonnn");
        } else {
            if ((Period.between(LocalDate.parse(userDto.getAge()), LocalDate.now()).getYears()) < 18) {
                errors.rejectValue("age", "date.age", "NONNN");
            }
        }

    }
}
