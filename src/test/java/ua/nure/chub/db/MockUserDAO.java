package test.java.ua.nure.chub.db;

import main.java.ua.nure.chub.User;
import main.java.ua.nure.chub.db.ConnectionFactory;
import main.java.ua.nure.chub.db.DatabaseException;
import main.java.ua.nure.chub.db.UserDAO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Author Lera
 * created 04.11.2017.
 */
public class MockUserDAO implements UserDAO {
    private long id = 0;
    private Map users = new HashMap();

    @Override
    public Long create(User user) throws DatabaseException {
        Long currentId = ++id;
        user.setId(currentId);
        users.put(currentId, user);
        return user.getId();
    }

    @Override
    public void update(User user) throws DatabaseException {
        Long currentId = user.getId();
        users.remove(currentId);
        users.put(currentId, user);
    }

    @Override
    public void delete(User user) throws DatabaseException {

    }

    @Override
    public User findById(Long id) throws DatabaseException {
        return (User) users.get(id);
    }

    @Override
    public Collection findAll() throws DatabaseException {
        return users.values();
    }

    @Override
    public void setConnectionFactory(ConnectionFactory connectionFactory) {

    }
}
