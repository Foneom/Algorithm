package com.foneom.collections.map.container;

import com.foneom.student.In;

import java.util.Arrays;

public class SimpleHashMap<K, V> {
    private final int DEFAULT_SIZE = 16;
    private int size = 0;
    private Node<K, V>[] list = new Node[DEFAULT_SIZE];


    boolean put(K key, V value) {
        boolean insert = true;
        for (int i = 0; i < size; i++) {
            if (list[i].getKey().equals(key)) {
                list[i].setValue(value);
                insert = false;
            }
        }
        if (insert) {
            newSize();
            list[size] = new Node<>(key, value);
            size++;
        }
        return insert;
    }

    void print() {
        for (int i = 0; i < size; i++) {
            System.out.print("Key: " + list[i].getKey() + " Value: "
                    + list[i].getValue()
                    + System.lineSeparator());
        }
    }


    private void newSize() {
        if (size == list.length) {
            int newSize = list.length * 2;
            list = Arrays.copyOf(list, newSize);
        }
    }

    private class Node<K, V> {
        private K key;
        private V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private static class Test {
        public static void main(String[] args) {
            SimpleHashMap<Integer, String> list = new SimpleHashMap<>();
            list.put(14, "Mama");
            list.put(17, "Koma");
            list.put(19, "Papa");
            list.print();
        }
    }
}
