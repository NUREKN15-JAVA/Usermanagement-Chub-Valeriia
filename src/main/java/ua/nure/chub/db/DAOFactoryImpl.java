package main.java.ua.nure.chub.db;

/**
 * Author Lera
 * created 03.11.2017.
 */
public class DAOFactoryImpl extends DAOFactory {

    @Override
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
