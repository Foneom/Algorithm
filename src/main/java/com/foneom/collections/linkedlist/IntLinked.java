package com.foneom.collections.linkedlist;

public class IntLinked {
    /**
     * Указатель на первый элемент списка
     */
    private IntNode head;
    /**
     * Указатель на последний элемент списка
     */
    private IntNode last;

    public void addFirst(int element) {
        IntNode intLinked = new IntNode(); //создаем новую ноду
        intLinked.data = element;//данные новой ноды
        if (last == null) { // если список пуст, то указываем ссылки начала и конца на первый элемент
        head = intLinked;
        last = intLinked;
        } else {
            last.next = intLinked;//иначе старый последний теперь ссылается на новый
            last = intLinked; //указатель на последний записываем
        }
}
public void printList() {
        IntNode node = head; // получаем ссылку на первый элемент
    System.out.print("[");
    while (node != null) { //пока нода существует
        System.out.print(node.data + ", ");// печатаем данные в ноде
        node = node.next; //и переходим к следующей
    }
    System.out.println("]");
}

    public static void main(String[] args) {
        IntLinked intLinked = new IntLinked();
        intLinked.addFirst(3);
        intLinked.addFirst(6);
        intLinked.printList();
    }

class IntNode {
        /**
         * Указатель на следующий элемент
         */
        IntNode next;
        /**
         * Данные
         */
        int data;
    }
}

