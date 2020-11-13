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

    public int[] getArr() {
        return arr;
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
    public boolean lineSearch(int key) {
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

    /**
     * Метод удаления элемента по ключу
     *
     * @param key
     * @return
     */
    public boolean deleteByKey(int key) {
        boolean isDeleted = false;
        int i;
        for (i = 0; i < nElem; i++) {
            if (arr[i] == key) {
                break;
            }
        }
        if (i != nElem) {
            for (int k = i; k < nElem; k++) {
                arr[k] = arr[k + 1];
            }
                nElem--;
                isDeleted = true;
        }
        return isDeleted;
    }

    public void remove(int index) {
        System.arraycopy(arr, index + 1, arr, index, arr.length - 1 - index);
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

    private void swap(int first, int second) {
        int tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;
    }

    public void bubbleSort() {
        int out, in;
        for (out = nElem - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (arr[in] > arr[in + 1]) {
                    swap(in, in + 1);
                }
            }
        }
    }

        public boolean binarySearch(int key) {
        int low = 0;
        int high = nElem - 1;
        boolean isSearched = false;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                isSearched = true;
                break;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else if (key < mid) {
                high = mid - 1;
            }
        }
        return isSearched;
    }
}



