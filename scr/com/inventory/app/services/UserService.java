package com.inventory.app.services;

import com.inventory.app.models.user.Roles;
import com.inventory.app.models.user.User;
import com.inventory.app.models.user.Users;

import java.util.List;

public class UserService {

    public static boolean isLogged(User user) {
        return user.getRoles().contains(Roles.USER);
    }

    public static boolean isAdmin(User user) {
        return user.getRoles().contains(Roles.ADMIN);
    }

    public static User register(Users users, String username, String password) {
        users.getUsers().add(new User(username,password, List.of(Roles.USER)));
        FileService.writeUsersFile(users);
        return new User(username, password, List.of(Roles.USER));
    }

    public static User logIn(Users users, String username, String password) {
        User user = UsersService.findUser(users, username);
        if (user != null && UsersService.findUser(users, username).getHashPassword().contains(password)) {
            System.out.println("Logged successfully!");
            return UsersService.findUser(users, username);
        } else {
            System.out.println("Wrong username or password!");
            return new User();
        }
    }

}
