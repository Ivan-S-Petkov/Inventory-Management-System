package com.inventory.app.models.user;

import java.util.ArrayList;
import java.util.List;

public class Users {

    private List<User> users;


    public Users() {
        users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

}
