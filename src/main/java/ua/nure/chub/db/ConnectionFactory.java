package main.java.ua.nure.chub.db;

import java.sql.Connection;

/**
 * Author Lera
 * created 22.10.2017.
 */
public interface ConnectionFactory {
    Connection createConnection() throws DatabaseException;
}
