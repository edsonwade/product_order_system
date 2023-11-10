package com.code.vanilson.jpa.respository;

import java.util.List;
import java.util.Optional;

public interface BookRepository<T> {
    List<T> findAll();

    Optional<T> findById(long id);

    T create(T t);

}
