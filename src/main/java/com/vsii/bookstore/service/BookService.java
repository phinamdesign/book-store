package com.vsii.bookstore.service;

import com.vsii.bookstore.model.Book;

import java.util.Optional;

public interface BookService {
    Optional<Book> findById(Integer id);
    Iterable<Book> findAll();
    Book save(Book book);
    void delete(Integer id);
}
