package com.inventory.app.services;

import com.inventory.app.models.InventoryItem;

public interface Item {
    void getDetails(InventoryItem item);

    String showDescription(InventoryItem item);

}
