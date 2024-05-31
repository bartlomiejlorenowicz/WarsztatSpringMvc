package com.coderslab.service;

import com.coderslab.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooks();

    Optional<Book> get(int id);

    void add(Book book);

    void delete(int id);

    void update(Book book);
}
