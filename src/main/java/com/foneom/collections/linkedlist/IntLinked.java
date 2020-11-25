package com.foneom.collections.linkedlist;

class IntLinked {
    private IntNode head;
    private int size;

    public IntLinked() {
        head = null;
    }

    public void addFirst(int value) {
        IntNode newNode = new IntNode(value);
        newNode = head.next;
        head.next = newNode;

    }


    public static void main(String[] args) {
        IntLinked intLinked = new IntLinked();
        intLinked.addFirst(3);
        intLinked.addFirst(6);
        // intLinked.printList();
    }

    class IntNode {
        IntNode next;
        int data;

        public IntNode(int val) {
            data = val;
        }


    }
}

