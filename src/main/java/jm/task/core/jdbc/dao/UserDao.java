package jm.task.core.jdbc.dao;

import java.sql.SQLException;
import jm.task.core.jdbc.model.User;

import java.util.List;
// Data Access Object
public interface UserDao {
    void createUsersTable() throws SQLException;

    void dropUsersTable() throws SQLException;

    void saveUser(String name, String lastName, byte age) throws SQLException;

    void removeUserById(long id) throws SQLException;

    List<User> getAllUsers() throws SQLException;

    void cleanUsersTable() throws SQLException;
}
