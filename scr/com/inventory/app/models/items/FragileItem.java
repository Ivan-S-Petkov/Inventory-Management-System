package com.inventory.app.models.items;

import com.inventory.app.models.InventoryItem;

public class FragileItem extends InventoryItem implements Sellable, Breakable {


    public FragileItem(int id, String name, String description,  double quantity, String type, String category, double price) {
        super(name, description, id, quantity, type, category, price);
    }

    @Override
    public boolean isBreakable() {
        return true;
    }

    @Override
    public void handleBreak() {

    }


    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double calculateValue() {
        return 0;
    }
}
