package ru.kpfu.itis.valeev.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {

    private Connection connection = null;

    public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {

        if (connection == null) {
            Properties prop = new Properties();
//            ServletContext context = new AppServletContextListener();
//
//            InputStream in = new FileInputStream("/properties/dp.properties");
////            InputStream inputStream = DbConnection.class.getClassLoader().getResourceAsStream("/WEB-INF/properties/dp.properties");
//
//            prop.load(in);
//            String driver = prop.getProperty("driver");
//            String url = prop.getProperty("url");
//            String user = prop.getProperty("user");
//            String password = prop.getProperty("password");
            String driver = "org.postgresql.Driver";
            String url = "jdbc:postgresql://localhost:5432/spring_valid_auth";
            String user = "postgres";
            String password = "postgres";
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;

    }
}
