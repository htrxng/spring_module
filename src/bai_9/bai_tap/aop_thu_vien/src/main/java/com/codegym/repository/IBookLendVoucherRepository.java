package com.codegym.repository;

import com.codegym.model.BookLendVoucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface IBookLendVoucherRepository extends JpaRepository<BookLendVoucher,Integer> {

    BookLendVoucher findByLendCode(Long codeLending);
}
