package com.codegym.service;

import com.codegym.exception.RunoutQuantity;
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
    public Boolean lendBookById(Integer id) throws RunoutQuantity {
        Boolean flag= false;
        Book book = iBookRepository.findById(id).orElse(null);
        if (book != null && book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() - 1);
            iBookRepository.save(book);
            flag = true;
        } else {
            throw new RunoutQuantity("hết sách rồi");
        }

        return flag;
    }

    @Override
    public void payBook(Book book) {
        book.setQuantity(book.getQuantity() + 1);
        iBookRepository.save(book);
    }


}
