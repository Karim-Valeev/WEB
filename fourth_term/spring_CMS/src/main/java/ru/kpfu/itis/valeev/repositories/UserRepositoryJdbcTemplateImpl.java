package ru.kpfu.itis.valeev.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.valeev.models.User;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@Repository
public class UserRepositoryJdbcTemplateImpl implements UserRepository {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

//    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
////        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
//    }

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "select * from \"user\" where id = ?";

    //language=SQL
    private static final String SQL_SELECT_BY_LOGIN = "select * from \"user\" where login = ?";

    private RowMapper<User> userRowMapper = (row, i) -> User.builder()
            .id(row.getLong("id"))
            .login(row.getString("login"))
            .email(row.getString("email"))
            .password(row.getString("password"))
            .build();


    public UserRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void save(User entity)  {
        jdbcTemplate.update("INSERT INTO \"user\"(login, email, password) VALUES (?, ?, ?);",1,2,3);
    }

    @Override
    public User findByID(Long id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, userRowMapper, id);
    }

    @Override
    public User findByLogin(String login) {
        return jdbcTemplate.queryForObject(SQL_SELECT_BY_LOGIN, userRowMapper, login);
    }

    @Override
    public void update(User entity){

    }

    @Override
    public void delete(User entity){

    }

    @Override
    public User findByEmail(String email){
        return null;
    }

}
