package com.codegym.service;

import com.codegym.model.Book;
import com.codegym.model.BookLendVoucher;
import com.codegym.repository.IBookLendVoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookLendVoucherService implements IBookLendVoucherService {
    @Autowired
    private IBookLendVoucherRepository iBookLendVoucherRepository;

    @Override
    public void save(BookLendVoucher bookLendVoucher) {
        iBookLendVoucherRepository.save(bookLendVoucher);
    }

    @Override
    public List<BookLendVoucher> findAll() {
        return iBookLendVoucherRepository.findAll();
    }

    @Override
    public BookLendVoucher findById(Integer id) {
        return iBookLendVoucherRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        iBookLendVoucherRepository.deleteById(id);
    }

    @Override
    public BookLendVoucher findByLendCode(Long lendCode) {
        return iBookLendVoucherRepository.findByLendCode(lendCode);
    }

    @Override
    public void delete(BookLendVoucher bookLendVoucher) {
        iBookLendVoucherRepository.delete(bookLendVoucher);
    }

}
