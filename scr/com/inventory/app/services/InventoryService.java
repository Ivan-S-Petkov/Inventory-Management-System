package com.inventory.app.services;

import com.inventory.app.models.Inventory;
import com.inventory.app.models.InventoryItem;
import com.inventory.app.models.items.AssetItem;
import com.inventory.app.models.items.ElectronicItem;
import com.inventory.app.models.items.FragileItem;
import com.inventory.app.models.items.GroceryItem;

import java.util.Objects;

public class InventoryService extends Inventory {

    public static boolean addInventory(Inventory inventory, String name, String description, double quantity, String type, String category, double price) {
        int ID = inventory.getInventory().size();
        boolean flag = false;
        if (Objects.equals(type, "electronic")) {
            inventory.getInventory().add(new ElectronicItem(ID, name, description, quantity, type, category, price));
            flag = true;
        } else if (Objects.equals(type, "fragile")) {
            inventory.getInventory().add(new FragileItem(ID, name, description, quantity, type, category, price));
            flag = true;
        } else if (Objects.equals(type, "grocery")) {
            inventory.getInventory().add(new GroceryItem(ID, name, description, quantity, type, category, price));
            flag = true;
        } else if (Objects.equals(type, "asset")) {
            inventory.getInventory().add(new AssetItem(ID, name, description, quantity, type, category, price));
            flag = true;
        }
        return flag;
    }

    public static void listInventoryItems(Inventory inventory) {
        ItemService itemService = new ItemService();
        inventory.getInventory().forEach(itemService::getDetails);
    }

    public static InventoryItem getInventoryItemByName(Inventory inventory, String name) {
        for (InventoryItem item : inventory.getInventory()) {
            if (item.getName().contains(name)) {
                return item;
            }
        }
        return null;
    }
}
