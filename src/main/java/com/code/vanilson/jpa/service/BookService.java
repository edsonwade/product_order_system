package com.code.vanilson.jpa.service;

import com.code.vanilson.jpa.config.BookConnectionConfig;
import com.code.vanilson.jpa.model.Book;
import com.code.vanilson.jpa.respository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookService extends BookConnectionConfig implements BookRepository<Book> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookService.class);
    List<Book> books = null;
    Optional<Book> bookOptional = Optional.empty();

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
        String sql = "SELECT book_id , title FROM tb_books WHERE book_id =?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)

        ) {
            preparedStatement.setLong(1, id);
            methodAuxiliaryForPreparedStatement(preparedStatement);
        } catch (SQLException e) {
            LOGGER.error("Failed to connecting to DB {}", e.getMessage());
        }
        return bookOptional;
    }

    private void methodAuxiliaryForPreparedStatement(PreparedStatement preparedStatement) {
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            Book respBook = new Book();
            if (resultSet.next()) {respBook.setBookId(resultSet.getLong("book_id"));}
            respBook.setTitle(resultSet.getString("title"));
            bookOptional = Optional.of(respBook);
        } catch (SQLException ex) {
            LOGGER.error("Failed to retrieve the data {}", ex.getMessage());
        }
    }

}
