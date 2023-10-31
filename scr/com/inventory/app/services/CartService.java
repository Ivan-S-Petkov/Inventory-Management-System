package com.inventory.app.services;

import com.inventory.app.models.Inventory;
import com.inventory.app.models.InventoryItem;
import com.inventory.app.models.user.User;

import static com.inventory.app.services.ValidationService.*;

public class CartService {
    public static void add(Inventory inventory, User user, String product, double quantity) {
        InventoryItem item = InventoryService.getInventoryItemByName(inventory, product);
        if (item != null && validateAvailableQuantity(item, quantity)) {
            InventoryItem itemToAdd = new InventoryItem(item);
            itemToAdd.setQuantity(quantity);
            user.getCart().add(item);
            System.out.println("Added to cart successfully! ");
        } else {
            System.out.println("Not enough quantity");
        }

    }

    public static void remove(User user, String product) {
        if (validateCartItemExist(user, product)) {
            InventoryItem itemToRemove = getCartItemByName(user, product);
            user.getCart().remove(itemToRemove);
        }
    }

    public static InventoryItem getCartItemByName(User user, String name) {
        for (InventoryItem item : user.getCart()) {
            if (item.getName().contains(name)) {
                return item;
            }
        }
        return null;
    }

    public static void viewCart(User user) {
        for (InventoryItem item : user.getCart()) {
            System.out.printf("%s - %s : %.2f %n", item.getName(), item.getDescription(), item.getQuantity());
        }
    }
}
