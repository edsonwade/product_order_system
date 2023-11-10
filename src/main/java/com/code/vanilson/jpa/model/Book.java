package com.code.vanilson.jpa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Table(name = "tg_books")
@Entity
@Getter
@Setter
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    @Column(name = "book_id")
    private Long bookId;
    @Column(name = "title", length = 100, nullable = false)
    private String title;

    public Book() {
        //default
    }

    public Book(Long bookId, String title) {
        this.bookId = bookId;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}

        Book book = (Book) o;

        if (!Objects.equals(bookId, book.bookId)) {return false;}
        return Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        int result = bookId != null ? bookId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                '}';
    }
}
