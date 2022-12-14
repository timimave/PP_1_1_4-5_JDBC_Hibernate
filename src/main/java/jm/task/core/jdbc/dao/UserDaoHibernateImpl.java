package jm.task.core.jdbc.dao;

import static jm.task.core.jdbc.util.Util.getSessionFactory;

import java.util.List;
import javax.persistence.Query;
import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class UserDaoHibernateImpl implements UserDao {
    private static String SQL;


    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
              transaction = session.beginTransaction();
              
            SQL = "CREATE TABLE IF NOT EXISTS userDB " +
                 "(id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, "
                + "name VARCHAR(45) NOT NULL, "
                + "last_name VARCHAR(45) NOT NULL, age INT)";

            session.createSQLQuery(SQL)
                .addEntity(User.class)
                .executeUpdate();

            transaction.commit();

        } catch (HibernateException e) {
            e.printStackTrace();

            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void dropUsersTable() {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
             transaction = session.beginTransaction();

            SQL = "DROP TABLE IF EXISTS userDB";

            session.createSQLQuery(SQL)
                .addEntity(User.class)
                .executeUpdate();
            transaction.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            

        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
             transaction = session.beginTransaction();
            User user = new User(name, lastName, age);

            SQL = "INSERT INTO userDB (name, last_name, age) VALUES ('" + name + "', '" +
                lastName + "', " + age + ")";

            session.createSQLQuery(SQL)
                .addEntity(User.class)
                .executeUpdate();

            transaction.commit();

            System.out.println("User с именем – " + user.getName() + " добавлен в базу данных");
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            SQL = "DELETE FROM userDB WHERE id = " + id;

            session.createSQLQuery(SQL)
                .addEntity(User.class)
                .executeUpdate();
            transaction.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        List userList = null;
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            SQL = "SELECT * FROM userDB";
            Query query = session.createSQLQuery(SQL)
                .addEntity(User.class);

            userList = query.getResultList();

            for (Object user : userList) {
                System.out.print(user.toString());
            }
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            SQL = "TRUNCATE TABLE userDB";

            session.createSQLQuery(SQL)
                .addEntity(User.class)
                .executeUpdate();
            transaction.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
