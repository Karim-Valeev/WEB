package ru.kpfu.itis.valeev.repositories;

import ru.kpfu.itis.valeev.models.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UserRepository extends CrudRepository<User> {
    User findByEmail(String email) throws SQLException, IOException, ClassNotFoundException;
}
