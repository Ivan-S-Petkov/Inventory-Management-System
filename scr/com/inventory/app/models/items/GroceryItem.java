package com.inventory.app.models.items;

import com.inventory.app.models.InventoryItem;

public class GroceryItem extends InventoryItem implements Perishable, Sellable {


    public GroceryItem(int id, String name, String description,  double quantity, String type, String category, double price) {
        super(name, description, id, quantity, type, category, price);
    }


    @Override
    public boolean isPerishable() {
        return true;
    }

    @Override
    public void handleExpiration() {
        System.out.printf("The out of date grocery has been removed from the shelf.");
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
        return quantity * price;
    }
}
