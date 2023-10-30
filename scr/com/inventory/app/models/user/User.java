package com.inventory.app.models.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    private String username;
    private List<Roles> roles;
    private String hashPassword;

    public User() {
        this.username = null;
        this.roles = new ArrayList<>();
        this.roles.add(Roles.GUEST);
    }

    public User(String username, String hashPassword, List<Roles> roles){
        this.username = username;
        this.hashPassword = hashPassword;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public String getHashPassword(){
        return hashPassword;
    }

    public String toString(){
        String rolesString = roles.stream().map(String::valueOf).collect(Collectors.joining(","));
        return String.join(",", username, hashPassword, rolesString);
    }
}
