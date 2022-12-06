package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Ivan", "Ivanov", (byte) 23);
        userService.saveUser("Petr", "Petrov", (byte) 32);
        userService.saveUser("Sergey", "Smirnov", (byte) 20);
        userService.saveUser("Andrey", "Khalezin", (byte) 33);
        System.out.println(userService.getAllUsers());

        userService.removeUserById(2);
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
