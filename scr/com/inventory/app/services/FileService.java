package com.inventory.app.services;

import com.inventory.app.models.Inventory;
import com.inventory.app.models.InventoryItem;
import com.inventory.app.models.user.Roles;
import com.inventory.app.models.user.Users;
import com.inventory.app.models.user.User;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.*;

import static com.inventory.app.services.InventoryService.addInventory;
import static com.inventory.app.services.UsersService.addUser;

public class FileService {
    private static final String dataFile = "inventory.txt";
    private static final String usersFile = "users.txt";

    public static void readDataFile(Inventory inventory) {
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
                addInventory(inventory, name, description, quantity, type, category, price);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDataFile(Inventory inventory) {
        try (FileWriter fw = new FileWriter(dataFile)) {
            for (InventoryItem inventoryItem : inventory.getInventory()) {
                fw.write(inventoryItem.toString().concat("\r\n"));
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static void readUsersFile(Users users) {
        try (FileReader fr = new FileReader(usersFile)) {
            Scanner sc = new Scanner(fr);
            while (sc.hasNextLine()) {
                ArrayDeque<String> row = new ArrayDeque<>(Arrays.stream(sc.nextLine().split(",")).toList());
                String username = row.poll();
                String hashPassword = row.poll();
                List<Roles> roles = new ArrayList<>();
                row.stream().toList().forEach(role -> {
                    roles.add(Roles.valueOf(role));
                });
                addUser(users, username, hashPassword, roles);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeUsersFile(Users users) {
        try (FileWriter fw = new FileWriter(usersFile)) {
            for (User user : users.getUsers()) {
                fw.write(user.toString().concat("\r\n"));
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }


}
