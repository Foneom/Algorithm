package com.foneom.collections.linkedlist;

import java.util.Iterator;

public class TestLink implements Iterable {
    /**
     * Певый элемент
     */
    private Node head;

    private Node last;

    private int size = 0;

    public void addFirst(int value) {
      Node newNode = new Node(value);
      newNode.next = head;
      head = newNode;
      size++;
    }
    public void addLast(int value) {
        Node toAdd = new Node(value);

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = toAdd;
        size++;
    }

    public void print() {
        Node current = head;
        System.out.print("[");
        int count = 0;
        while (current != null) {
            System.out.print(current.item);
            current = current.next;
            count++;
            if (count < size) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    @Override
    public Iterator iterator() {

        return new Iterator() {
            Node add = head;
            @Override
            public boolean hasNext() {
                return add != null;
            }

            @Override
            public Object next() {
                int val = add.item;
                add = add.next;
                return val;
            }
        };
    }
}

class Node {
    /**
     * Ссылка на следующий элемент
     */
    Node next;
    /**
     * Ссылка на предыдущий элемент
     */
    Node prev;
    int item;

    public Node(int item) {
        this.item = item;
        next = null;
    }
}

class Test {
    public static void main(String[] args) {
        TestLink link = new TestLink();
        link.addFirst(5);
        link.addFirst(10);
        link.addFirst(7);
        link.addLast(18);
        //link.print();
        Iterator iterator = link.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
    }
}


