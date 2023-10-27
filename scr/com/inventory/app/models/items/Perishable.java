package com.inventory.app.models.itemTypes;

public interface Perishable {
    public boolean isPerishable();
    public void handleExpiration();
}
