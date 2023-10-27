package com.inventory.app;

import com.inventory.app.models.Inventory;

import java.util.Scanner;

import static com.inventory.app.services.FileService.*;
import static com.inventory.app.services.InventoryService.*;
import static com.inventory.app.services.MenuService.*;

public class Main {
    public static void main(String[] arr) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();
        readFile(inventory);
        showMenu();
        while (sc.hasNext()) {
            String command = sc.nextLine();
            switch (command) {
                case "add":
                    // Reading console input
                    String name = getName(inventory, sc);
                    String description = getDescription(sc);
                    double quantity = getQuantity(sc);
                    String type = getType(sc);
                    String category = getCategory(sc);

                    addInventory(inventory, name, description, quantity, type, category,0);
                    writeFile(inventory);
                    System.out.println("Product added successfully!");
                    break;
                case "list":
                    listInventoryItems(inventory);
                    break;
                case "categorize":
                    break;
                case "order":
                    break;
                default:
                    System.out.println("Command not found!");
                    break;
            }
        }
    }


}
