package com.inventory.app;

public abstract class AbstractItem {

    public abstract double getQuantity();

    public abstract void setQuantity(double quantity);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract String getDescription();

    public abstract void setDescription(String description);

    public abstract String writeData();

}
