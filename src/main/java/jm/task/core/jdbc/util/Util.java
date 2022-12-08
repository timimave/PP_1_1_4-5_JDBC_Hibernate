package jm.task.core.jdbc.util;

import java.lang.module.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.hibernate.SessionFactory;

public class Util {   // реализуйте настройку соеденения с БД

    static String connectionUrl = "jdbc:mysql://localhost:3306/test";
    static String userName = "root";
    static String password = "3122546ti";
    private static SessionFactory sessionFactory;


    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionUrl, userName,
                password);
            System.out.println("we are connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static SessionFactory getSessionFactory() {
        Configuration configuration;

        return null;
    }

    public static void main(String[] args) {
        getConnection();
    }


}
