package com.codegym.repository;

import com.codegym.model.BookLendVoucher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookLendVoucherRepository extends JpaRepository<BookLendVoucher,Integer> {


    BookLendVoucher findByCodeLending(Long codeLending);
}
