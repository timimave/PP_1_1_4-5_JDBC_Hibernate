package jm.task.core.jdbc.service;

import java.sql.SQLException;
import java.util.List;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

public class UserServiceImpl implements UserService {
    UserDao daoHibernate = new UserDaoHibernateImpl();



    public void createUsersTable() {
        try {
            daoHibernate.createUsersTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try {
            daoHibernate.dropUsersTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            daoHibernate.saveUser(name, lastName, age);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try {
            daoHibernate.removeUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        try {
            return daoHibernate.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void cleanUsersTable() {
        try {
            daoHibernate.cleanUsersTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
