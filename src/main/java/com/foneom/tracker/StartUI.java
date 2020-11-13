package com.foneom.tracker;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

public class StartUI {
    private static final String MSG = "";

public static void createItem(Input input, Tracker tracker) {
    System.out.println("=== Create a new Item ===");
    System.out.print("Enter name: ");
    String name = input.askStr(MSG);
    Item item = new Item(name);
    tracker.add(item);
}

public static void allItems(Input input, Tracker tracker) {
    System.out.println("=== All Items ===");
    for (Item item : tracker.findAll()) {
        System.out.println("id: " + item.getId() + " name: " + item.getName());
    }
}

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        System.out.println("Enter id: ");
        String id = input.askStr(MSG);
        System.out.println("Enter new name: ");
        String newName = input.askStr(MSG);
        Item newItem = new Item(newName);
        tracker.replace(id, newItem);
    }

    public static void delete(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        System.out.println("Enter id: ");
        String id = input.askStr(MSG);
        tracker.delete(id);
}

public static void findItemById(Input input, Tracker tracker) {
    System.out.println("=== Find item by id ===");
    System.out.println("Enter id: ");
    String id = input.askStr(MSG);
    System.out.println("id:" +  id + " name: " + tracker.findById(id));
}

public static void findItemByName(Input input, Tracker tracker) {
    System.out.println("=== Find item by name ===");
    System.out.println("Enter name: ");
    String name = input.askStr(MSG);
    for (Item item : tracker.findByName(name)) {
        System.out.println("id:" + item.getId() + " name: " + item.getName());
    }
}
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            String msg = " ";
            int select = input.askInt(msg);
            if (select == 0) {
                createItem(input, tracker);
            } else if (select == 1) {
               allItems(input, tracker);
            } else if (select == 2) {
              editItem(input, tracker);
            } else if (select == 3) {
               delete(input, tracker);
            } else if (select == 4) {
               findItemById(input, tracker);
            } else if (select == 5) {
               findItemByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu."
                + "\n0.Add new Item"
                + "\n1.Show all items"
                + "\n2.Edit item"
                + "\n3.Delete item"
                + "\n4.Find item by id"
                + "\n5.Find items by name"
                + "\n6.Exit Program"
                + "\nSelect: ");
    }


}
