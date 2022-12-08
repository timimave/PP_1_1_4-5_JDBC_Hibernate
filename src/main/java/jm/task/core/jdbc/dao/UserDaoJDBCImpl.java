package jm.task.core.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

public class UserDaoJDBCImpl implements UserDao {

    static private String createUsersTable =
        "create table if not exists users_table " +
            "(id bigint auto_increment, " +
            "name varchar(128), " +
            "lastName varchar(128), " +
            "age tinyint, primary key (id))";
    static private String dropUsersTable = "drop table if exists users_table";
    String saveUser = "insert into users_table "
        + "(name, lastName, age) values (?, ?, ?)";
    static private String removeUserById = "delete from users_table where id=?";
    static private String getAllUsers = "select * from users_table";
    static private String cleanUsersTable = "truncate table users_table";
//    static Connection connection = Util.getConnection();


    public UserDaoJDBCImpl() {

    }

    //Каждый метод дао должен вызывать Util.getConnection(),
    // работать с Connection и закрывать его.
    public void createUsersTable() throws SQLException {
        Connection connection = Util.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(createUsersTable);
            connection.setAutoCommit(false);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        } finally {
            connection.close();
        }
    }


    public void dropUsersTable() throws SQLException {
        Connection connection = Util.getConnection();
        try {
            PreparedStatement preparedStatement =
                connection.prepareStatement(dropUsersTable);
            preparedStatement.executeUpdate();
            connection.setAutoCommit(false);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            connection.close();
        }
    }

    public void saveUser(String name, String lastName, byte age)
        throws SQLException {
        Connection connection = Util.getConnection();
        try {
            PreparedStatement preparedStatement =
                connection.prepareStatement(saveUser);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            connection.setAutoCommit(false);
            connection.commit();
            System.out.println(
                "User с именем – " + name + " добавлен в базу данных");

        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            connection.close();
        }
    }

    public void removeUserById(long id) throws SQLException {
        Connection connection = Util.getConnection();
        try {
            PreparedStatement preparedStatement =
                connection.prepareStatement(removeUserById);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            connection.setAutoCommit(false);
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            connection.close();
        }
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        Connection connection = Util.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                getAllUsers);
            ResultSet resultSet = preparedStatement.executeQuery();
            connection.setAutoCommit(false);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            connection.close();
        }
        return users;
    }

    public void cleanUsersTable() throws SQLException {
        Connection connection = Util.getConnection();
        try {
            PreparedStatement preparedStatement =
                connection.prepareStatement(cleanUsersTable);
            preparedStatement.executeUpdate();
            connection.setAutoCommit(false);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();

        } finally {
            connection.close();
        }
    }
}
