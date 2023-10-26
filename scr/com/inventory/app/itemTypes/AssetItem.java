package com.inventory.app.itemTypes;

import com.inventory.app.Breakable;
import com.inventory.app.InventoryItem;

public class AssetItem extends InventoryItem implements Breakable {


    public AssetItem(int id, double quantity, String name, String description, String type) {
        super(id, quantity, name, description, type);
    }

    @Override
    public boolean isBreakable() {
        return true;
    }

    @Override
    public void handleBreak() {

    }
}
