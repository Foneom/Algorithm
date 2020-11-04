package com.foneom.collections.arraylist;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleArrayList<T> implements Iterable<T> {
    /**
     * Класс - обертка над массивом
     @param <T>
     */
    /**
     * Контейнер элементов
     */
    private Object[] arr;
    /**
     * Количество элементов
     */
    private int size;

    /**
     * Конструктор
     *
     * @param maxSize - размер контейнера
     */
    public SimpleArrayList(int maxSize) {
        arr = new Object[maxSize];
        size = 0;
    }

    /**
     * Метод добавления элемента в контейнер
     *
     * @param value
     */
    public void add(T value) {
        arr[size] = value;
        size++;
    }


    public int getSize() {
        return size;
    }

    private void swap(int first, int second) {
        T tmp = (T) arr[first];
        arr[first] = (T) arr[second];
        arr[second] = tmp;
    }

    /**
     * Метод замены элемента по индексу
     *
     * @param index - индекс
     * @param obj   - новое значение
     */
    public void set(int index, T obj) {
        for (int i = 0; i < size; i++) {
            if (i == index) {
                arr[index] = obj;
            }
        }
    }

    /**
     * Метод удаления элемента из коллекции
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        T value = null;
        int i;
        for (i = 0; i < size; i++) {
            if (i == index) {
                arr[index] = value;
                break;
            }
            if (index > i) {
                break;
            }
        }
        for (int j = i; j < size; j++) {
            arr[j] = arr[j + 1];
        }
        size--;
        return value;
    }

    /**
     * Метод вывода карточки работника по индексу
     *
     * @param index
     * @return
     */
    public T get(int index) {
        T value = null;
        for (int i = 0; i < size; i++) {
            if (i == index && index != size) {
                value = (T) arr[index];
                break;
            }
        }
        return value;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < size
                        && arr[currentIndex] != null;
            }

            @Override
            public T next() {
                return (T) arr[currentIndex++];
            }
        };
    }
}

