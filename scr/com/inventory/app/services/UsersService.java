package com.inventory.app.services;

import com.inventory.app.models.user.Roles;
import com.inventory.app.models.user.User;
import com.inventory.app.models.user.Users;

import java.util.List;

public class UsersService {

    public static void addUser(Users users, String username, String hashPassword, List<Roles> roles) {
        users.getUsers().add(new User(username, hashPassword, roles));
    }

    public static User findUser(Users users, String username) {
        for (User user : users.getUsers()) {
            if (user.getUsername().contains(username)) {
                return user;
            }
        }
        return null;
    }
}
