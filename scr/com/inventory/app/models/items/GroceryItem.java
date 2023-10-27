package com.inventory.app.models.itemTypes;

import com.inventory.app.models.InventoryItem;

public class GroceryItem extends InventoryItem implements Perishable, Sellable {


    public GroceryItem(int id, double quantity, String name, String description, String type) {
        super(id, quantity, name, description, type);
    }

    @Override
    public boolean isPerishable() {
        return true;
    }

    @Override
    public void handleExpiration() {

    }

    @Override
    public void setPrice() {

    }

    @Override
    public void getPrice() {

    }
}
