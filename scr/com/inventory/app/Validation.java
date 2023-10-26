package com.inventory.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validation {

    private final List<String> types = new ArrayList<>(Arrays.stream(new String[]{"electronic", "fragile", "grocery"}).toList());


    private boolean checkName(Inventory inventory, String name) {
        if (inventory.getInventory().isEmpty() || inventory.getInventory().stream().noneMatch(inventoryItem -> inventoryItem.getName().contains(name))){
            return true;
        } else{
            System.out.println("Name already exist!");
            return false;
        }
    }

    private boolean checkType(String type) {
        if (types.contains(type)) {
            return true;
        } else {
            System.out.println("Invalid type!");
            return false;
        }
    }

    private boolean checkQuantity(String quantity) {
        try {
            Double number = Double.parseDouble(quantity);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Quantity is not a number!");
            return false;
        }
    }

    public boolean validateAddInputs(Inventory inventory, String name, String description, String quantity, String type) {
        return checkName(inventory, name) && checkQuantity(quantity) && checkType(type);
    }

}
