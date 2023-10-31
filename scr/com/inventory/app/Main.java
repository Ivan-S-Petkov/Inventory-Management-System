package com.inventory.app;

import com.inventory.app.models.Inventory;
import com.inventory.app.models.InventoryItem;
import com.inventory.app.models.user.User;
import com.inventory.app.models.user.Users;
import com.inventory.app.services.CartService;
import com.inventory.app.services.FileService;
import com.inventory.app.services.InventoryService;
import com.inventory.app.services.UserService;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

import static com.inventory.app.services.FileService.*;
import static com.inventory.app.services.InventoryService.*;
import static com.inventory.app.services.MenuService.*;
import static com.inventory.app.services.ValidationService.*;

public class Main {
    public static void main(String[] arr) throws NoSuchAlgorithmException, InvalidKeySpecException {
        Scanner sc = new Scanner(System.in);
        Users users = new Users();
        FileService.readUsersFile(users);
        User user = new User();
        Inventory inventory = new Inventory();
        readDataFile(inventory);
        showMenu(user);
        while (sc.hasNext()) {
            String command = sc.nextLine();
            switch (command) {
                case "menu":
                    showMenu(user);
                    break;
                case "add":
                    // Reading console input
                    String name = getName(inventory, sc);
                    String description = getDescription(sc);
                    double quantity = getQuantity(sc);
                    String type = getType(sc);
                    String category = getCategory(sc);

                    addInventory(inventory, name, description, quantity, type, category, 0);
                    writeDataFile(inventory);
                    System.out.println("Product added successfully!");
                    break;
                case "list":
                    listInventoryItems(inventory);
                    break;
                case "categorize":
                    name = getName(inventory, sc, "edit");
                    category = getCategory(sc);
                    InventoryItem item = getInventoryItemByName(inventory, name);
                    item.setCategory(category);
                    writeDataFile(inventory);
                    System.out.println("Product category edited successfully!");
                    break;
                case "cart":
                    showCartMenu();
                    command = sc.nextLine();
                    switch (command) {
                        case "add":
                            name = getName(inventory, sc, "add");
                            quantity = getQuantity(sc);
                            CartService.add(inventory, user,name, quantity);
                            break;
                        case "remove":
                            name = getName(inventory, sc, "remove");
                            CartService.remove(user, name);
                            break;
                        case "view":
                            CartService.viewCart(user);
                            break;
                        default:
                            System.out.println("No such cart command");
                            break;
                    }
                    break;
                case "order":
                    break;
                case "login":
                    String username = getUsername(sc, users, "login");
                    String password = getPassword(sc, "login");
                    user = UserService.logIn(users, username, password);
                    break;
                case "register":
                    username = getUsername(sc, users, "register");
                    password = getPassword(sc, "register");
                    String rePassword = getPassword(sc, "register", "register");
                    if (validatePasswordMatch(password, rePassword)) {
                        user = UserService.register(users, username, password);
                    } else {
                        System.out.println("Passwords do not match!");
                    }
                    break;
                case "logout":
                    user = new User();
                    break;
                default:
                    System.out.println("Command not found!");
                    showMenu(user);
                    break;
            }
        }
    }


}
