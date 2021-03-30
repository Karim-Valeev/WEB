package ru.kpfu.itis.valeev.repositories;

import java.io.IOException;
import java.sql.SQLException;

public interface CrudRepository<T> {
    T findByID(Long id);
    void save(T entity);
    void update(T entity);
    void delete(T entity);
}
