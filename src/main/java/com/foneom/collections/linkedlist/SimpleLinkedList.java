package com.foneom.collections.linkedlist;

import java.util.Objects;

public class SimpleLinkedList<T> {
    /**
     * Размер коллекции
     */
    private int size;
    /**
     * Первый элемент
     */
    private Node<T> header;

    public SimpleLinkedList() {
        size = 0;
    }

    public static void main(String[] args) {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(7);
        
    }

   public T get(int index) {
       Objects.checkIndex(index, size);
       return null;
   }

    public boolean isEmpty() {
        return header == null;
    }

    public void addFirst(T value) {
        Node newNode = new Node<>(value, header, header.prev);
        newNode.prev.next = newNode;
        newNode.next.prev = newNode;
            size++;
        }

    private class Node<T> {
        /**
         * Значение
         */
        T item;
        /**
         * Ссылка на предыдущий элемент
         */
        Node<T> prev;
        /**
         * Ссылка на седующий элемент
         */
        Node<T> next;

        public Node(T element, Node<T> next, Node<T> prev ) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        public void getItem() {
            System.out.print(item);
        }
    }
}
