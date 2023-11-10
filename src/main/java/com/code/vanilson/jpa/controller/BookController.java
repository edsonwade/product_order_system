package com.code.vanilson.jpa.controller;

import com.code.vanilson.jpa.model.Book;
import com.code.vanilson.jpa.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> listAllBooks() {
        return ResponseEntity.ok().body(bookService.findAll());
    }
}
