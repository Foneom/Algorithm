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

        private int indexOf(int index) {
            for(int i = 0; i < size; i++) {
                if (arr[i] == arr[index]) {
                    break;
                }
            }
            return index;
        }

        public int getSize() {
            return size;
        }

    /**
     * Метод удаления элемента из коллекции
     * @param index
     * @return
     */
        public T remove(int index) {
            T value = null;
            int i;
            for (i = 0; i < size; i++) {
                if (i == index) {
                    value = (T) arr[index];
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
     * @param index
     * @return
     */
    public T get(int index) {
            T value = null;
            for (int i = 0; i < size; i++) {
                value = (T) arr[i];
                if (i == index && index < size) {
                    arr[index] = value;
                    break;
                } else {
                    break;
                }
            }
            return value;
        }
    }

