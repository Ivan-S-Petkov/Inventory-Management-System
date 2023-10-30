package com.inventory.app.models.items;

public interface Perishable {
    public boolean isPerishable();
    public void handleExpiration();
}
