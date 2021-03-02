package ru.kpfu.itis.valeev.repositories;

import ru.kpfu.itis.valeev.helpers.HashHelper;
import ru.kpfu.itis.valeev.models.User;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class UserRepositoryJdbcImpl extends JdbcRepo implements UserRepository {

    private User user = null;

    @Override
    public User findByID(Long id) throws SQLException, IOException, ClassNotFoundException {
        return null;
    }

    @Override
    public void create(User entity) throws SQLException, IOException, ClassNotFoundException {
        try {
            st = connection.prepareStatement(
                    "INSERT INTO \"user\"(login, email, password, bio) VALUES (?, ?, ?, ?);");
            st.setString(1, user.getLogin());
            st.setString(2, user.getEmail());
            st.setString(3, HashHelper.getHash(user.getPassword()));
            st.setString(4, user.getBio());
            //        08-Jan-1999   1999-01-08
            st.executeUpdate();
            st.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(User entity) throws SQLException, IOException, ClassNotFoundException {

    }

    @Override
    public void delete(User entity) throws SQLException, IOException, ClassNotFoundException {

    }

    @Override
    public User findByEmail(String email) throws SQLException, IOException, ClassNotFoundException {
        return null;
    }
}
