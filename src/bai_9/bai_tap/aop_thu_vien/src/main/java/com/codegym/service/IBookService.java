package com.codegym.service;

import com.codegym.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    void save(Book book);

    Book findById(Integer id);

    String lendBookById(Integer id);


    String payBookByCodeLending(Integer id, String codeLending);
}
