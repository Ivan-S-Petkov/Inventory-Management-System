package com.inventory.app;

public interface Perishable {
    public boolean isPerishable();
    public void handleExpiration();
}
