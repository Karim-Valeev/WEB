package ru.kpfu.itis.valeev.services;

import ru.kpfu.itis.valeev.models.User;

import java.io.IOException;
import java.sql.SQLException;


public interface UserService {
    void addUser(User user) throws SQLException, IOException, ClassNotFoundException;
}
