package com.foneom.arrays;

public class HighArray {
    /**
     * Массив чисел
     */
    private int[] arr;
    /**
     * Фактическое число элементов в массиве
     */
    private int nElem;

    /**
     * Конструктор
     * @param maxSize - максимальное количество элементов в массиве
     */
    public HighArray(int maxSize) {
        this.arr = new int[maxSize];
        this.nElem = 0;
    }

    /**
     * Метод вставки значения в массив
     * @param value
     */
    public void insert(int value) {
        arr[nElem] = value;
        nElem++;
    }

    public int getNElem() {
        return nElem;
    }

    /**
     * Метод поиска элемента в массиве
     * @param key
     * @return
     */
    public boolean search(int key) {
        boolean isSearched = false;
        for (int i = 0; i < nElem; i++) {
            if (arr[i] == key) {
                isSearched = true;
                break;
            } else if (i == nElem) {
                System.out.println("Искомый элемент отсутствует");
            }
        }
        return isSearched;
    }

    public int[] getArray() {
        for (int i = 0; i < nElem; i++) {

        }
            return arr;
    }

    /**
     * Метод вывода массива на печать
     */
    public void print() {
        System.out.print("[");
        for (int i = 0; i < nElem; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public boolean delete(int key) {
        boolean isDeleted = false;
        int i;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                break;
            }
            if (i == nElem) {
            }
        }
            for (int k = i; k < nElem; k++) {
                    arr[k] = arr[k + 1];
                    nElem--;
                    isDeleted = true;
            }
            return isDeleted;
    }
}
