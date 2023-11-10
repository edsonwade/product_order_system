package com.code.vanilson.jpa.service;

import com.code.vanilson.jpa.config.BookConnectionConfig;
import com.code.vanilson.jpa.model.Book;
import com.code.vanilson.jpa.respository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookService extends BookConnectionConfig implements BookRepository<Book> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookService.class);
    List<Book> books = null;

    @Override
    public List<Book> findAll() {
        String sql = "SELECT * FROM tb_books";

        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            books = new ArrayList<>();

            while (resultSet.next()) {
                Book book = new Book();
                book.setBookId(resultSet.getLong("book_id"));
                book.setTitle(resultSet.getString("title"));
                books.add(book);
            }

        } catch (SQLException e) {
            LOGGER.error("Cannot connecting :{}", e.getMessage());
        }
        return books;
    }

    @Override
    public Optional<Book> findById(long id) {
        return Optional.empty();
    }

}
