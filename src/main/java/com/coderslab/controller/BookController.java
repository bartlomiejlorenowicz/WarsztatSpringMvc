package com.coderslab.controller;

import com.coderslab.model.Book;
import com.coderslab.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<Book> getList() {
        return bookService.getBooks();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void addBook(@RequestBody Book book) {
        bookService.add(book);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return this.bookService.get(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        });
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public void updateBook(@RequestBody Book book) {
        bookService.update(book);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        bookService.delete(id);
    }

}
