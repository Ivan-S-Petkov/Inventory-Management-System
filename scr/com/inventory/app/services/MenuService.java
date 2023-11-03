package com.inventory.app.services;

import com.inventory.app.models.Inventory;
import com.inventory.app.models.user.User;
import com.inventory.app.models.user.Users;

import java.util.Scanner;

import static com.inventory.app.services.ValidationService.*;

public class MenuService {

    public static void showMenu(User user) {
        System.out.println("Available commands:");
        System.out.println("  menu");
        if (!UserService.isLogged(user)) {
            System.out.println("  login");
            System.out.println("  register");
        }
        if (UserService.isLogged(user)) {
            System.out.println("  list");
            if (UserService.isAdmin(user)) {
                System.out.println("  add");
                System.out.println("  categorize");
            }
            System.out.println("  cart");
            System.out.println("  order");
            System.out.println("  logout");
        }
    }

    public static String getName(Inventory inventory, Scanner sc, boolean checkExisting, boolean getExisting) {
        System.out.print("Specify product name: ");
        String name = sc.nextLine();
        while (!validateName(inventory, name, checkExisting, getExisting)) {
            name = sc.nextLine();
        }
        return name;
    }

    public static String getDescription(Scanner sc) {
        System.out.print("Specify product description: ");
        String description = sc.nextLine();
        // Description is redundant but left in case future validation should be implemented
        return description;
    }

    public static double getQuantity(Scanner sc) {
        System.out.print("Specify product quantity: ");
        String quantity = sc.nextLine();
        while (!validateQuantity(quantity)) {
            quantity = sc.nextLine();
        }
        return Double.parseDouble(quantity);
    }

    public static String getType(Scanner sc) {
        System.out.print("Specify product type: ");
        String type = sc.nextLine();
        while (!validateType(type)) {
            type = sc.nextLine();
        }
        return type;
    }

    public static String getCategory(Scanner sc) {
        System.out.print("Specify product category: ");
        String category = sc.nextLine();
        // Category is redundant but left in case future validation should be implemented
        return category;
    }

    public static double getPrice(Scanner sc) {
        System.out.print("Specify product price: ");
        String price = sc.nextLine();
        while (!validatePrice(price)) {
            price = sc.nextLine();
        }
        return Double.parseDouble(price);
    }

    public static String getUsername(Scanner sc, Users users, String command) {
        System.out.print("Username: ");
        String username = sc.nextLine();
        while (!validateUsername(users, username, command)) {
            username = sc.nextLine();
        }
        return username;
    }

    public static String getPassword(Scanner sc, String command, String... repeat) {
        if (repeat.length > 0) {
            System.out.print("Repeat password: ");
        } else {
            System.out.print("Password: ");
        }
        String password = sc.nextLine();
        while (!validatePassword(command, password)) {
            password = sc.nextLine();
        }
        return password;
    }

    public static void showCartMenu() {
        System.out.println("Possible cart actions:");
        System.out.println("  add");
        System.out.println("  remove");
        System.out.println("  view");
    }
}
