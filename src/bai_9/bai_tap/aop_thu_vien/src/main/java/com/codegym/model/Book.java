package com.codegym.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    private String bookName;
    private String author;
    private String manufacturer;
    private Integer quantity;

    @OneToMany(mappedBy = "book")
    private List<BookLendVoucher> bookLendVoucherList;

}
