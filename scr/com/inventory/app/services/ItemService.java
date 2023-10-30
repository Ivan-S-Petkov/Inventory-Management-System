package com.inventory.app.services;

import com.inventory.app.models.InventoryItem;

public class ItemService implements Item {

    @Override
    public void getDetails(InventoryItem item) {
        System.out.printf("%s - %s : %.2f %n", item.getName(), item.getDescription(), item.getQuantity());
    }

    @Override
    public String showDescription(InventoryItem item) {
        return item.getDescription();
    }



}
