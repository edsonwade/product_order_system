package com.code.vanilson.jpa.respository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BookRepository<T> {
    List<T> findAll() throws SQLException;

    Optional<T> findById(long id);


}
