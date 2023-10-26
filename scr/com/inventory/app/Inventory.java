package com.inventory.app;

import com.inventory.app.itemTypes.ElectronicItems;
import com.inventory.app.itemTypes.FragileItem;
import com.inventory.app.itemTypes.GroceryItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inventory {
    private List<InventoryItem> inventory;

    public Inventory() {
        this.inventory = new ArrayList<>();
    }

    public void add( String name, String description, double quantity, String type) {
        int ID = inventory.size();
        if (Objects.equals(type, "electronic")) {
            inventory.add(new ElectronicItems(ID, quantity, name, description, type));
        }
        if (Objects.equals(type, "fragile")) {
            inventory.add(new FragileItem(ID, quantity, name, description, type));
        }
        if (Objects.equals(type, "grocery")) {
            inventory.add(new GroceryItem(ID, quantity, name, description, type));
        }
    }

    public List<InventoryItem> getInventory() {
        return inventory;
    }

    public void lsitAllItems(){
        inventory.forEach(inventoryItem -> System.out.printf("%s - %s: %.2f %n", inventoryItem.getName(), inventoryItem.getDescription(), inventoryItem.getQuantity()));
    }



}
