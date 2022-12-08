package jm.task.core.jdbc.service;

import java.sql.SQLException;
import java.util.List;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

public class UserServiceImpl implements UserService {

    UserDao userDaoJDBC = new UserDaoJDBCImpl();

    public void createUsersTable()  {
        try {
            userDaoJDBC.createUsersTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable()  {
        try {
            userDaoJDBC.dropUsersTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            userDaoJDBC.saveUser(name, lastName, age);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try {
            userDaoJDBC.removeUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        try {
            return userDaoJDBC.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void cleanUsersTable() {
        try {
            userDaoJDBC.cleanUsersTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
