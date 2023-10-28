package com.inventory.app.services;

import com.inventory.app.models.Inventory;

import java.util.Scanner;

import static com.inventory.app.services.ValidationService.*;

public class MenuService {

    public static void showMenu() {
        System.out.println("Available commands:");
        System.out.println(" - add");
        System.out.println(" - list");
        System.out.println(" - categorize");
        System.out.println(" - order");
    }

    public static String getName(Inventory inventory, Scanner sc) {
        System.out.print("Specify product name: ");
        String name = sc.nextLine();
        while (!validateName(inventory, name)) {
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

    public static String getCategory(Scanner sc){
        System.out.print("Specify product category: ");
        String category = sc.nextLine();
        // Category is redundant but left in case future validation should be implemented
        return category;
    }


}
