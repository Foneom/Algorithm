package com.foneom.tracker;

import java.util.Arrays;
import java.util.UUID;

public class Tracker {
    /**
     * Хранилище заявок
     */
    private final Item[] items = new Item[100];

    /**
     * Фактическое количество элементов
     */
    private int size = 0;


    /**
     * Метод возвращает фактическое число заявок в контейнере на текущий момент
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    private int indexOf(String id) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (items[i].getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }


    public String getIdByItem(Item item) {
        return String.valueOf(item.getId());
    }

    /**
     * Метод добавления заявок в хранилище
     *
     * @param item
     * @return
     */
    public Item add(Item item) {
        items[size++] = item;
        return item;
    }

    /**
     * Метод поиска заявок по id
     *
     * @param id
     * @return
     */
    public Item findById(String id) {
        Item rsl = null;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (item.getId().equals(id)) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод вывода списка элементов
     *
     * @return
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    /**
     * Метод поиска заявки по имени
     *
     * @param name
     * @return
     */
    public Item[] findByName(String name) {
        int nElem = 0;
        Item[] rsl = new Item[size];
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (item.getName().equals(name)) {
                nElem++;
                rsl = Arrays.copyOf(items, nElem);
            }
        }
        return rsl;
    }

    /**
     * Метод замены заявки в хранилище
     *
     * @param id   - id заявки
     * @param item - новая заявка
     * @return
     */
    public boolean replace(String id, Item item) {
        boolean isReplaced = false;
        int searchedIndex;
        for (searchedIndex = 0; searchedIndex < size; searchedIndex++) {
            if (items[searchedIndex].getId().equals(id)) {
                item.setId(id);
                items[searchedIndex] = item;
                isReplaced = true;
                break;
            }
        }
        return isReplaced;
    }

    /**
     * Метод удаления заявки по id
     * @param id
     * @return
     */
    public boolean delete(String id) {
        boolean isDeleted = false;
        int deletedIndex;
        for (deletedIndex = 0; deletedIndex < size; deletedIndex++) {
            if (items[deletedIndex].getId().equals(id)) {
                break;
            } else if (deletedIndex == size) {
                break;
            }
        }
        for (int j = deletedIndex; j < size; j++) {
            items[j] = items[j + 1];
            size--;
            isDeleted = true;
        }
        return isDeleted;
    }

    public void remove(String id) {
        int index = indexOf(id);
        System.arraycopy(items, index + 1, items, index, size - index - 1);
    }

}


