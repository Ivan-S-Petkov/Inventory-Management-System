package com.inventory.app.models;

import com.inventory.app.models.user.User;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private final User user;
    private List<InventoryItem> items;
    private final LocalDate date;
    private String status;


    public Order(User user, List<InventoryItem> items) {
        this.user = user;
        this.items = items;
        this.date = LocalDate.now();
        this.status = String.valueOf(Statuses.PLACED);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<InventoryItem> getItems() {
        return items;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getDate() {
        return date;
    }

    public String toString() {
        StringBuilder itemsString = new StringBuilder();
        for (InventoryItem item : items) {
            itemsString.append(String.join(",", item.getName(), String.valueOf(item.getQuantity()), String.valueOf(item.price)));
        }

        return String.join(",", user.getUsername(), String.valueOf(date), status, itemsString);
    }
}
