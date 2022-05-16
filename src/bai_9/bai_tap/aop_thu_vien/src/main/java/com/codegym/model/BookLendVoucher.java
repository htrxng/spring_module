package com.codegym.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BookLendVoucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer voucherId;
    private Long lendCode;

    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "bookId")
    private Book book;


}
