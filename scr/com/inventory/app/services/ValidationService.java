package com.inventory.app.services;

import com.inventory.app.models.Inventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidationService {

    private static final List<String> types = new ArrayList<>(Arrays.stream(new String[]{"electronic", "fragile", "grocery","asset"}).toList());


    static boolean validateName(Inventory inventory, String name) {
        if(name.isEmpty()){
            System.out.println("The name is empty!");
            System.out.print("Please type the name again: ");
            return false;
        }
        //Check if name already exists
        if (inventory.getInventory().isEmpty() || inventory.getInventory().stream().noneMatch(inventoryItem -> inventoryItem.getName().contains(name))){
            return true;
        } else{
            System.out.println("Name already exist!");
            System.out.print("Please type the name again: ");
            return false;
        }
    }



    static boolean validateType(String type) {
        if (types.contains(type)) {
            return true;
        } else {
            System.out.println("Invalid type!");
            System.out.print("Please specify the type again: ");
            return false;
        }
    }

    static boolean validateQuantity(String quantity) {
        try {
            double number = Double.parseDouble(quantity);
            if (number>0){
            return true;}
            else{
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

    private static boolean checkCategory(String category){
        return !category.isEmpty();
    }

}
