package com.foneom.arrays;

import java.util.Arrays;

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
     *
     * @param maxSize - максимальное количество элементов в массиве
     */
    public HighArray(int maxSize) {
        this.arr = new int[maxSize];
        this.nElem = 0;
    }

    /**
     * Метод вставки значения в массив
     *
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
     *
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
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
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
        for (i = 0; i < nElem; i++) {
            if (arr[i] == key) {
                break;
            } else if (i == nElem) {
                break;
            }
        }
        for (int k = i; k < nElem; k++) {
            arr[k] = arr[k + 1];
            nElem--;
            isDeleted = true;
        }
        return isDeleted;
    }

    public boolean lineSearch(int key) {
        boolean isSearched = false;
        for (int i = 0; i < nElem; i++) {
            if (arr[i] == key) {
                isSearched = true;
                break;
            } else if (i == nElem) {
                break;
            }
        }
        return isSearched;
    }

    public void remove(int index) {
        System.arraycopy(arr, index + 1, arr, index, arr.length - index - 1);
    }

    private void swap(int first, int second) {
        int tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;

    }

    public void bubbleSort1() {
        boolean isSorted = false;
        while (true) {
            isSorted = true;
            for (int i = 0; i < nElem - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(i, i + 1);
                }
            }
        }



    }

    public static void main(String[] args) {
        HighArray arr = new HighArray(10);
        arr.insert(3);
        arr.insert(2);
        arr.insert(4);
        arr.print();
        System.out.println();
        arr.bubbleSort1();
        arr.print();
    }
}



