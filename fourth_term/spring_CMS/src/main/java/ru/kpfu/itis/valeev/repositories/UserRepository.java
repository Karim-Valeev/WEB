package ru.kpfu.itis.valeev.repositories;

import ru.kpfu.itis.valeev.models.User;

import java.io.IOException;
import java.sql.SQLException;

public interface UserRepository extends CrudRepository<User> {
    User findByLogin(String login);
    User findByEmail(String email);
}
