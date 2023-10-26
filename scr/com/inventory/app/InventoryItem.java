package com.inventory.app;

public class InventoryItem extends AbstractItem implements Categorizable {
    private final int ID;
    private double quantity;
    private String name;
    private String description;
    private String type;

    private String category;

    public InventoryItem(int id, double quantity, String name, String description, String type) {
        ID = id;
        this.quantity = quantity;
        this.name = name;
        this.description = description;
        this.type = type;
        this.category = "";
    }

    @Override
    public double getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String writeData() {
        return String.join(",", String.valueOf(ID), name, description, String.valueOf(quantity), type);
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String getCategory() {
        return category;
    }

}
