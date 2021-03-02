package ru.kpfu.itis.valeev.repositories;

import java.io.IOException;
import java.sql.SQLException;

public interface CrudRepository<T> {
    T findByID(Long id) throws SQLException, IOException, ClassNotFoundException;
    void create(T entity) throws SQLException, IOException, ClassNotFoundException;
    void update(T entity) throws SQLException, IOException, ClassNotFoundException;
    void delete(T entity) throws SQLException, IOException, ClassNotFoundException;
}
