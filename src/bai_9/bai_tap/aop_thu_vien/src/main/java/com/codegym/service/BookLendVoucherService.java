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
    public String findByCodeLending(Long codeLending) {
        String notice = null;
        BookLendVoucher bookLendVoucher = iBookLendVoucherRepository.findByCodeLending(codeLending);
        if(bookLendVoucher != null) {
            notice = "bạn đã trả sách thành công!";
            Book book = bookLendVoucher.getBook();
            book.setQuantity(book.getQuantity()+1);
            iBookLendVoucherRepository.delete(bookLendVoucher);
        } else {
            notice = "bạn đã nhập mã sai";
        }
        return notice;
    }
}
