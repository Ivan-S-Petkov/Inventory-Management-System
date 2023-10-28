package com.inventory.app.services;

import com.inventory.app.models.Inventory;
import com.inventory.app.models.InventoryItem;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;

import static com.inventory.app.services.InventoryService.addInventory;

public class FileService {
    private static final String dataFile = "inventory.txt";

    public static void readFile(Inventory inventory) {
        try (FileReader fr = new FileReader(dataFile)) {
            Scanner sc = new Scanner(fr);
            while (sc.hasNextLine()) {
                String[] row = sc.nextLine().split(",");
                int ID = Integer.parseInt(row[0]);
                String name = row[1];
                String description = row[2];
                double quantity = Double.parseDouble(row[3]);
                String type = row[4];
                String category = row[5];
                double price = Double.parseDouble(row[6]);
                addInventory(inventory, name,description,quantity,type, category, price);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(Inventory inventory) {
        try (FileWriter fw = new FileWriter(dataFile)) {
            for (InventoryItem inventoryItem : inventory.getInventory()) {
                fw.write(inventoryItem.toString().concat("\r\n"));
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
