package com.codegym.service;

import com.codegym.model.BookLendVoucher;

import java.util.List;

public interface IBookLendVoucherService {
    void save(BookLendVoucher bookLendVoucher);

    List<BookLendVoucher> findAll();

    BookLendVoucher findById(Integer id);

    void deleteById(Integer id);


    BookLendVoucher findByLendCode(Long lendCode);

    void delete(BookLendVoucher bookLendVoucher);
}
