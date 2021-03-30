package ru.kpfu.itis.valeev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.valeev.models.User;
import ru.kpfu.itis.valeev.repositories.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllUsers(int page, int size) {
        //return from(usersRepository.findAll(page, size));
        return null;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(User.builder().
                login(user.getLogin())
                .build());
    }

    @Override
    public User getUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
