package com.codegym.service;

import com.codegym.exception.RunoutQuantity;
import com.codegym.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    void save(Book book);

    Book findById(Integer id);

    Boolean lendBookById(Integer id) throws RunoutQuantity;

    void payBook(Book book);
}
