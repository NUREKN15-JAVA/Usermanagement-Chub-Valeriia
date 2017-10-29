package main.java.ua.nure.chub.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Author Lera
 * created 23.10.2017.
 */
public class DAOFactory {
    private static final String USER_DAO = "main.java.ua.nure.chub.db.UserDAO";
    private final Properties properties;
    private static final DAOFactory INSTANCE = new DAOFactory();

    public static DAOFactory getInstance() {
        return INSTANCE;
    }

    public DAOFactory() {
        InputStream inputStream;
        properties = new Properties();
        try {
            inputStream = new FileInputStream("src/main/resources/settings.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private ConnectionFactory getConnectionFactory() {
        String user = properties.getProperty("connection.user");
        String password = properties.getProperty("connection.password");
        String url = properties.getProperty("connection.url");
        String driver = properties.getProperty("connection.driver");

        return new ConnectionFactoryImpl(driver, url, user, password);
    }

    public UserDAO getUserDAO() {
        UserDAO result = null;
        try {
            Class clazz = Class.forName(properties.getProperty(USER_DAO));
            HsqldbUserDAO userDAO = (HsqldbUserDAO) clazz.newInstance();
            userDAO.setConnectionFactory(getConnectionFactory());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}
