package main.java.ua.nure.chub.db;

import main.java.ua.nure.chub.User;

import java.util.Collection;


/**
 * Author Lera
 * created 21.10.2017.
 */
public interface UserDAO {
    Long create(User user) throws DatabaseException;

    void update(User user) throws DatabaseException;

    void delete(User user) throws DatabaseException;

    User findById(Long id) throws DatabaseException;

    Collection findAll() throws DatabaseException;

    public void setConnectionFactory(ConnectionFactory connectionFactory);

    Collection find(String firstName, String lastName) throws DatabaseException;
}
