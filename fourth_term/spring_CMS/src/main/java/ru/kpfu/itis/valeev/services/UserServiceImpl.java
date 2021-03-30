package ru.kpfu.itis.valeev.services;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.valeev.models.User;
import ru.kpfu.itis.valeev.repositories.UserRepository;

import java.io.IOException;
import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository usersRepository) {
        this.userRepository = userRepository;
    }

//    ToDo обработать исключения
    @Override
    public void addUser(User user)  {
        userRepository.save(user);
    }

    @Override
    public User getUser(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findByID(id);
    }

}
