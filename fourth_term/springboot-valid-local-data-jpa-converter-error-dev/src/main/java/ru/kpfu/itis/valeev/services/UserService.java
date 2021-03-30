package ru.kpfu.itis.valeev.services;

import ru.kpfu.itis.valeev.models.User;

import java.util.List;


public interface UserService {
    List<User> getAllUsers();
    List<User> getAllUsers(int page, int size);
    void addUser(User user);

    User getUser(Long userId);
}
