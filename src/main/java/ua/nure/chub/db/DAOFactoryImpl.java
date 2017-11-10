package main.java.ua.nure.chub.db;

/**
 * Author Lera
 * created 03.11.2017.
 */
public class DAOFactoryImpl extends DAOFactory {

    @Override
    public UserDAO getUserDAO() {
        //UserDAO result = null;
        HsqldbUserDAO userDAO;
        try {
            //Class clazz = Class.forName(properties.getProperty(USER_DAO));
            //userDAO = (HsqldbUserDAO) clazz.newInstance();
            userDAO = new HsqldbUserDAO();
            userDAO.setConnectionFactory(getConnectionFactory());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userDAO;
    }
}
