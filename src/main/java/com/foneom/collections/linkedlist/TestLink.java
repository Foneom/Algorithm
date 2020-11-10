package com.foneom.collections.linkedlist;

import java.util.Iterator;

public class TestLink {
    private Node head;
    private int size;

    public void addFirst(int value) {
        Node newNode = new Node(value);//создаем новую ноду с элементом value
        newNode.next = head;//переопределяем ссылку
        head = newNode;
        size++;
    }

    public void addLast(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        size++;
    }

    public void print() {
        Node current = head;//идем от начала списка
        int count = 0;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
            count++;
            if (count > 0 && count < size) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public void deleteFirst(int val) {
        Node current = head;
        while (current.data != val) {
            current = current.next;
        }
        Node tmp = head;
        head = tmp.next;
        tmp.next = tmp;
        size--;
    }

    public void delete(int val) {
        Node current = head;
        while (current.next.data != val) {

        }
        current.next = current.next.next;
        size--;
    }

    public void get(int val) {
        Node current = head;
        while (current.data != val) {
            current = current.next;
        }
        System.out.println(System.lineSeparator() + current.data);
    }
}


class Node {
    Node next;
    Node prev;
    int data;

    public Node(int data) {
        this.data = data;
        next = null;
        prev = null;
    }

}

class Test {
    public static void main(String[] args) {
        TestLink link = new TestLink();
        link.addFirst(4);
        link.addFirst(7);
        link.addLast(10);
        link.print();
        link.get(7);
        link.deleteFirst(7);
        link.print();
        link.delete(10);
        System.out.println();
        link.print();
    }
}


