package com.codegym.service;

import com.codegym.model.Book;
import com.codegym.model.BookLendVoucher;
import com.codegym.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public Book findById(Integer id) {
        return iBookRepository.findById(id).orElse(null);
    }

    @Override
    public String lendBookById(Integer id) {
        String notice = null;
        Book book = iBookRepository.findById(id).orElse(null);
        if (book != null && book.getQuantity() > 0) {
            // chuyển save voucher lên controller xử lí 
            Long lendCode = Math.round(Math.random() * 89999 + 10000);
            BookLendVoucher bookLendVoucher = new BookLendVoucher();
            bookLendVoucher.setLendCode(lendCode);
            bookLendVoucher.setBook(book);
            iBookLendVoucherService.save(bookLendVoucher);
            book.setQuantity(book.getQuantity() - 1);
            iBookRepository.save(book);
            notice = "bạn đã mượn thành công quyển" + book.getBookName();
        } else {
            notice = "sách " + book.getBookName()+ " đã được mượn hết mất rồi!, \n bạn quay trở lại sau nhé!";
        }
        return notice;
    }

    @Override
    public String payBookByCodeLending(Integer id, String codeLending) {
        String notice = null;
        BookLendVoucher bookLendVoucher = iBookLendVoucherService.findById(id);
        if(bookLendVoucher != null) {
            if(bookLendVoucher.getLendCode() == Long.parseLong(codeLending)){
                Book book = bookLendVoucher.getBook();
                book.setQuantity(book.getQuantity()+1);
                iBookRepository.save(book);
                iBookLendVoucherService.deleteById(id);
                notice = "trả sách thành công! Mời bạn tiếp tục chọn đọc";
            } else {
                notice  = "mã trả sách không đúng, vui lòng kiểm tra lại";
            }
        } else {
            notice = "không tìm thấy phiếu mượn trong hệ thống";
        }
        return notice;
    }



}
