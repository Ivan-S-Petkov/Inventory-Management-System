package com.inventory.app.itemTypes;

import com.inventory.app.Breakable;
import com.inventory.app.InventoryItem;
import com.inventory.app.Sellable;

public class FragileItem extends InventoryItem implements Sellable, Breakable {


    public FragileItem(int id, double quantity, String name, String description, String type) {
        super(id, quantity, name, description, type);
    }

    @Override
    public boolean isBreakable() {
        return true;
    }

    @Override
    public void handleBreak() {

    }

    @Override
    public void setPrice() {

    }

    @Override
    public void getPrice() {

    }
}
