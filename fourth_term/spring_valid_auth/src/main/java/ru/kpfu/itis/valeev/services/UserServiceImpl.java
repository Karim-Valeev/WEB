package ru.kpfu.itis.valeev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.valeev.helpers.HashHelper;
import ru.kpfu.itis.valeev.models.User;
import ru.kpfu.itis.valeev.repositories.UserRepository;

import java.io.IOException;
import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
//    Todo нормально компоненты раскидать
    private HashHelper hashHelper;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) throws SQLException, IOException, ClassNotFoundException {
//        Hashing password using helper
        user.setPassword(HashHelper.getHash(user.getPassword()));
        try{
            userRepository.create(user);
        } catch (NullPointerException ex) {
//            make method return String;
//            return "error-jsp-page";
            System.out.println("Empty user given");
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            System.out.println("Problem while saving to DB appeared");
        }

    }
}
