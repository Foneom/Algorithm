package com.foneom.collections;

public class SimpleArrayList<T> {
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
         * @param maxSize - размер контейнера
         */
    public SimpleArrayList(int maxSize) {
            arr = new Object[maxSize];
            size = 0;
        }

        /**
         * Метод добавления элемента в контейнер
         * @param value
         */
        public void add(T value) {
            arr[size] = value;
            size++;
        }

        public T get(int index) {
            T value = null;
            for (int i = 0; i < size; i++) {
                value = (T) arr[i];
                if (i == index) {
                    arr[index] = value;
                    break;
                }
            }
            return value;
        }
    }

