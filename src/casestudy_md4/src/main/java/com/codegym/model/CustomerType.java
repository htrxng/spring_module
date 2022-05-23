package com.codegym.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerTypeId;
    private String customerTypeName;

    @OneToMany(mappedBy = "customerType")
    private List<Customer> customerList;


}
