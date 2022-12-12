package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        userService.createUsersTable();
//        userService.saveUser("Mike", "Mayer", (byte) 23);
//        userService.saveUser("Bob", "Dylan", (byte) 32);
//        userService.saveUser("Sasha", "Tailor", (byte) 20);
//        userService.saveUser("Patric", "Malcovic", (byte) 33);
//        System.out.println(userService.getAllUsers());
//
//        userService.removeUserById(2);
//        userService.cleanUsersTable();
//       userService.dropUsersTable();

        UserServiceImpl u = new UserServiceImpl();

       // u.createUsersTable();

//        u.saveUser("Mike", "Mayer", (byte) 18);
//        u.saveUser("Bob", "Dylan", (byte) 22);
//        u.saveUser("Sasha", "Tailor", (byte) 26);
//        u.saveUser("Patric", "Johnson", (byte) 74);


       u.getAllUsers();
//
//        u.cleanUsersTable();
//
//        u.getAllUsers();
//
//        u.dropUsersTable();


    }
}
