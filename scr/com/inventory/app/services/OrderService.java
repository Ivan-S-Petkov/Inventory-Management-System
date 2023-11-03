package com.inventory.app.services;

import com.inventory.app.models.Inventory;
import com.inventory.app.models.InventoryItem;
import com.inventory.app.models.Order;
import com.inventory.app.models.user.User;

import java.util.ArrayList;

import static com.inventory.app.services.ValidationService.validateAvailableQuantity;

public class OrderService {

    public static void order(User user, Inventory inventory) {
        if (!user.getCart().isEmpty()) {
            Order order = new Order(user, new ArrayList<>());
            for (InventoryItem item : user.getCart()) {
                // Obtain inventoryItem quantity and checks again if the quantity in warehouse is sufficient to fulfill the order
                InventoryItem inventoryItem = InventoryService.getInventoryItemByName(inventory, item.getName());
                assert inventoryItem != null;
                if (validateAvailableQuantity(inventoryItem, item.getQuantity())) {
                    // Subtract inventory quantity
                    double newQuantity = inventoryItem.getQuantity() - item.getQuantity();
                    inventoryItem.setQuantity(newQuantity);
                    // Add item to order
                    order.getItems().add(item);
                } else {
                    System.out.printf("Not enough quantity of %s! %n", item.getName());
                }
            }
            // Update inventory file if order is placed
            if (!order.getItems().isEmpty()) {
                FileService.writeDataFile(inventory);
                FileService.appendOrdersFile(order);
                // Remove ordered items from the cart
                for (InventoryItem item : order.getItems()) {
                    user.getCart().remove(item);
                }
            }
        } else {
            System.out.println("Cart is empty!");
        }
    }


}
