package com.inventory.app.models.items;

import com.inventory.app.models.InventoryItem;

public class AssetItem extends InventoryItem implements Breakable {


    public AssetItem(int id, String name, String description, double quantity, String type, String category, double price) {
        super(name, description, id, quantity, type, category, price);
    }

    @Override
    public boolean isBreakable() {
        return true;
    }

    @Override
    public void handleBreak() {

    }
}
