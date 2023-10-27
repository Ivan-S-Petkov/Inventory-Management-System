package com.inventory.app.services;

import com.inventory.app.models.Inventory;
import com.inventory.app.models.items.ElectronicItem;
import com.inventory.app.models.items.FragileItem;
import com.inventory.app.models.items.GroceryItem;

import java.util.Objects;

public class InventoryService {

    public static boolean addInventory(Inventory inventory, String name, String description, double quantity, String type) {
        int ID = inventory.getInventory().size();
        boolean flag = false;
        if (Objects.equals(type, "electronic")) {
            inventory.getInventory().add(new ElectronicItem(ID, quantity, name, description, type));
            flag = true;
        } else if (Objects.equals(type, "fragile")) {
            inventory.getInventory().add(new FragileItem(ID, quantity, name, description, type));
            flag = true;
        } else if (Objects.equals(type, "grocery")) {
            inventory.getInventory().add(new GroceryItem(ID, quantity, name, description, type));
            flag = true;
        }
        return flag;
    }

    public static void listInventoryItems(Inventory inventory) {
        inventory.getInventory().forEach(inventoryItem -> System.out.printf("%s - %s: %.2f %n", inventoryItem.getName(), inventoryItem.getDescription(), inventoryItem.getQuantity()));
    }
}
