package com.foneom.tracker;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

public class StartUI {


    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== All Items ===");
                for (Item item : tracker.findAll()) {
                    System.out.println("id: " + item.getId() + " name: " + item.getName());
                }
                tracker.findAll();
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                System.out.println("Enter id: ");
                String id = scanner.nextLine();
                System.out.println("Enter new name: ");
                String newName = scanner.nextLine();
                Item newItem = new Item(newName);
                tracker.replace(id, newItem);
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                System.out.println("Enter id: ");
                String id = scanner.nextLine();
                tracker.delete(id);
            } else if (select == 4) {
                System.out.println("=== Find item by id ===");
                System.out.println("Enter id: ");
                String id = scanner.nextLine();
                System.out.println("id:" +  id + " name: " + tracker.findById(id));
            } else if (select == 5) {
                System.out.println("=== Find item by name ===");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                for (Item item : tracker.findByName(name)) {
                    System.out.println("id:" +  item.getId() + " name: " + item.getName());
                }
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
