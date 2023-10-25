package com.inventory.app;

import java.util.Scanner;

public class Menu {

    public static void showMenu(){
        System.out.println("Available commands:");
        System.out.println(" * add");
        System.out.println(" * list");
        System.out.println(" * categorize");
        System.out.println(" * order");
    }

    public static String[] getAddValues(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Specify product name");
        String name = sc.nextLine();
        System.out.println("Specify product description");
        String description = sc.nextLine();
        System.out.println("Specify product quantity");
        String quantity = sc.nextLine();
        System.out.println("Specify product type");
        String type = sc.nextLine();
        return new String[]{name, description, quantity, type};
    }
}
