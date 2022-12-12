package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class Util {   // реализуйте настройку соеденения с БД
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static String connectionUrl = "jdbc:mysql://localhost:3306/test";
    static String userName = "root";
    static String password = "3122546ti";
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, DRIVER);
                settings.put(Environment.URL, connectionUrl);
                settings.put(Environment.USER, userName);
                settings.put(Environment.PASS, password);
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");


                Configuration config = new Configuration()
                    .setProperties(settings)
                    .addAnnotatedClass(User.class);


                ServiceRegistry serviceRegistry = new
                    StandardServiceRegistryBuilder()
                    .applySettings(config.getProperties())
                    .build();

                sessionFactory = config.buildSessionFactory(serviceRegistry);


                System.out.println("_______БД подключена через Hibernate_______");
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println("Не могу настроить подключение к БД" + e);
            }
        }
        return sessionFactory;
    }
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection =
                DriverManager.getConnection(connectionUrl, userName, password);
            System.out.println("we are connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
    public static void main(String[] args) {
        //  getConnection();
        getSessionFactory();
    }


}
