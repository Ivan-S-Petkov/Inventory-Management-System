package com.inventory.app.services;

import com.inventory.app.models.Inventory;
import com.inventory.app.models.InventoryItem;
import com.inventory.app.models.user.User;
import com.inventory.app.models.user.Users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ValidationService {

    private static final List<String> types = new ArrayList<>(Arrays.stream(new String[]{"electronic", "fragile", "grocery", "asset"}).toList());


    // Optional variable checkExisting is used to perform additional check
    static boolean validateName(Inventory inventory, String name, boolean checkExisting, boolean getExisting) {
        if (name.isEmpty()) {
            System.out.println("The name is empty!");
            System.out.print("Please type the name again: ");
            return false;
        }
        if (checkExisting && !getExisting) {
            if (inventory.getInventory().isEmpty() || inventory.getInventory().stream().noneMatch(inventoryItem -> inventoryItem.getName().contains(name))) {
                return true;
            } else {
                System.out.println("Name already exist!");
                System.out.print("Please type the name again: ");
                return false;
            }
        }
        if (checkExisting && getExisting) {
            if (inventory.getInventory().isEmpty() || inventory.getInventory().stream().noneMatch(inventoryItem -> inventoryItem.getName().contains(name))) {
                System.out.println("Name does not exist!");
                System.out.print("Please type the name again: ");
                return false;
            } else {
                return true;
            }
        }

        return true;
    }


    static boolean validateType(String type) {
        if (types.contains(type)) {
            return true;
        } else {
            System.out.println("Invalid type!");
            System.out.println("Available types:");
            System.out.println("  grocery");
            System.out.println("  electronic");
            System.out.println("  fragile");
            System.out.println("  asset");
            System.out.print("Please specify the type again: ");
            return false;
        }
    }

    static boolean validateQuantity(String quantity) {
        try {
            double number = Double.parseDouble(quantity);
            if (number > 0) {
                return true;
            } else {
                System.out.println("Quantity must be positive number!");
                System.out.print("Please type the quantity again: ");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Quantity is not a number!");
            System.out.print("Please type the quantity again: ");
            return false;
        }
    }

    static boolean validatePrice(String price) {
        try {
            double number = Double.parseDouble(price);
            if (number > 0) {
                return true;
            } else {
                System.out.println("Price must be positive number!");
                System.out.print("Please type the price again: ");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Price is not a number!");
            System.out.print("Please type the price again: ");
            return false;
        }
    }

    static boolean validateUsername(Users users, String username, String command) {
        if (username.isEmpty()) {
            System.out.println("The username is empty!");
            System.out.print("Please type your username again: ");
            return false;
        }
        // Check if username already exits only if user is trying to register
        if (command.contains("register")) {
            if (users.getUsers().isEmpty() || users.getUsers().stream().noneMatch(user -> user.getUsername().contains(username))) {
                return true;
            } else {
                System.out.println("Name already exist!");
                System.out.print("Please type the username again: ");
                return false;
            }
        }
        return true;
    }

    static boolean validatePassword(String command, String password) {
        if (password.isEmpty()) {
            System.out.println("The password is empty!");
            System.out.print("Please type your password again: ");
            return false;
        }
        if (command.contains("register")) {
            // Check if password contains at least one digit
            if (password.matches(".*\\d.*")) {
                return true;
            } else {
                System.out.println("Password should contain at least one digit!");
                System.out.print("Please type the password again: ");
                return false;
            }
        }
        return true;
    }

    public static boolean validatePasswordMatch(String password, String rePassword) {
        return Objects.equals(password, rePassword);
    }

    public static boolean validateAvailableQuantity(InventoryItem item, double quantity) {
        return item.getQuantity() >= quantity;
    }

    public static boolean validateCartItemExist(User user, String name) {
        for (InventoryItem item : user.getCart()) {
            return item.getName().contains(name);
        }
        System.out.println("This product is not in your cart!");
        return false;
    }
}
