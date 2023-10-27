package com.inventory.app.models;


import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<InventoryItem> inventory;

    public Inventory() {
        this.inventory = new ArrayList<>();
    }

    public List<InventoryItem> getInventory() {
        return inventory;
    }


    // Not sure if I need this setter
    public void setInventory(List<InventoryItem> inventory) {
        this.inventory = inventory;
    }
}
