package com.inventory.app.models;

public class InventoryItem extends AbstractItem implements Categorizable {
    protected final int ID;
    protected double quantity;

    protected final String type;
    protected String category;
    protected double price;

    protected InventoryItem(String name, String description, int id, double quantity, String type, String category, double price) {
        super(name, description);
        this.ID = id;
        this.quantity = quantity;
        this.type = type;
        this.category = category;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String getCategory() {
        return this.category;
    }


    @Override
    public String toString() {
        return String.join(",", String.valueOf(ID), name, description, String.valueOf(quantity), type, category, String.valueOf(price));
    }
}
