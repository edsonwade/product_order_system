package com.code.vanilson.jpa.controller;

import com.code.vanilson.jpa.model.Book;
import com.code.vanilson.jpa.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Book>> findBookById(@PathVariable Long id) {
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent()) {
            return ResponseEntity.ok()
                    .body(book);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Book> createNewBook(@RequestBody Book book) {
        Book books = bookService.create(book);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(books);

    }
}
