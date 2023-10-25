package com.inventory.app;

import java.util.Scanner;

import static com.inventory.app.File.*;
import static com.inventory.app.Menu.*;

public class Main {
    public static void main(String[] arr) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();
        readFile(inventory);
        Validation validation = new Validation();
        showMenu();
        while (sc.hasNext()) {
            String command = sc.nextLine();
            switch (command) {
                case "add":
                    String[] addValues = getAddValues();
                    String name = addValues[0];
                    String description = addValues[1];
                    String quantity = addValues[2];
                    String type = addValues[3];
                    if (validation.validateAddInputs(inventory, name, description, quantity, type)) {
                        inventory.add(name, description, Double.parseDouble(quantity), type);
                        writeFile(inventory);
                        System.out.println("Product added successfully!");
                    }
                    break;
                case "list":
                    inventory.lsitAllItems();
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
