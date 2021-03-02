package ru.kpfu.itis.valeev.repositories;

import ru.kpfu.itis.valeev.db.DbConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcRepo {

    protected Connection connection;
    protected PreparedStatement st;
    protected ResultSet rs;

    public JdbcRepo(){
        try {
            this.connection = new DbConnection().getConnection();
        } catch (SQLException | IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

}
