package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {   // реализуйте настройку соеденения с БД

    static String connectionUrl = "jdbc:mysql://localhost:3306/test";
    static String userName = "root";
    static String password = "3122546ti";


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

    public static void main(String[] args) {
          getConnection();
    }


}
