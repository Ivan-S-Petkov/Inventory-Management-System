package com.inventory.app.itemTypes;

import com.inventory.app.InventoryItem;
import com.inventory.app.Perishable;
import com.inventory.app.Sellable;

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
