package com.codegym.dto;

import lombok.Data;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class SongDto {
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
    @Pattern(regexp = "^([\\w]*[\\s]*[\\w]*[,]*)*$", message = "type can not contain special character")
    private String type;

}
