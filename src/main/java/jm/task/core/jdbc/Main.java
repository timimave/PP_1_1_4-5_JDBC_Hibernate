package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Mike", "Mayer", (byte) 23);
        userService.saveUser("Bob", "Dylan", (byte) 32);
        userService.saveUser("Sasha", "Tailor", (byte) 20);
        userService.saveUser("Patric", "Malcovic", (byte) 33);
        System.out.println(userService.getAllUsers());

        userService.removeUserById(2);
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
