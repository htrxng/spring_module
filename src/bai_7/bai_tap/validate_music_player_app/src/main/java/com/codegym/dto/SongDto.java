package com.codegym.dto;

import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class SongDto implements Validator {
    private Integer id;

    @NotEmpty(message = "name can not be empty")
    @Size(max = 800, message = "must be less than 800 character!")
    @Pattern(regexp = "^([\\w]*[\\s]*[\\w]*)*$", message = "name can not contain special character")
    private String name;
    @NotEmpty(message = "singer can not be empty")
    @Size(max = 300, message = "must be less than 300 character!")
    @Pattern(regexp = "^([\\w]*[\\s]*[\\w]*)*$", message = "singer can not contain special character")
    private String singer;
    @NotEmpty(message = "type can not be empty")
    @Size(max = 1000, message = "must be less than 1000 character!")
    @Pattern(regexp = "^([\\w]*[\\s]*[\\w]*[,]*)*$", message = "type can not contain special character except [,] ")
    private String type;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}