package com.coderslab.service;

import com.coderslab.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MockBookService implements BookService {

    private List<Book> list;

    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1, "9788324631766", "Thinking in Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(3, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    @Override
    public List<Book> getBooks() {
        return list;
    }

    @Override
    public Optional<Book> get(int id) {
        return list.stream().filter(book -> book.getId() == id).findFirst();
    }

    @Override
    public void add(Book book) {
        list.add(book);
    }

    @Override
    public void delete(int id) {
        list.removeIf(book -> book.getId() == id);
    }

    @Override
    public void update(Book book) {
        get(book.getId()).ifPresent(existingBook -> {
            existingBook.setIsbn(book.getIsbn());
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setPublisher(book.getPublisher());
            existingBook.setType(book.getType());
        });
    }
}
