package com.foneom.tracker;

import java.util.Arrays;

public class Tracker {
    /**
     * Хранилище заявок
     */
    private final Item[] items = new Item[100];

    private int ids = 1;
    /**
     * Фактическое количество элементов
     */
    private int size = 0;

    /**
     * Метод добавления заявок в хранилище
     * @param item
     * @return
     */
    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    /**
     * Метод поиска заявок по id
     * @param id
     * @return
     */
    public Item findById(int id) {
        Item rsl = null;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод вывода списка элементов
     * @return
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    /**
     * Метод поиска заявки по имени
     * @param name
     * @return
     */
    public Item[] findByName(String name) {
        int nElem = 0;
        Item[] rsl = new Item[nElem];
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (item.getName().equals(name)) {
                nElem++;
                rsl = Arrays.copyOf(items, nElem);
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Item(1, "Mama"));
        tracker.add(new Item(2, "Papa"));
        tracker.add(new Item(2, "Papa"));
        System.out.println(Arrays.toString(tracker.findAll()));
        System.out.println(Arrays.toString(tracker.findByName("Papa")));

    }
}
