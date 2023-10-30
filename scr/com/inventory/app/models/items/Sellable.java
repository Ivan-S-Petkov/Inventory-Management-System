package com.inventory.app.models.items;

public interface Sellable {
    void setPrice(double price);

    double getPrice();

    double calculateValue();
}
