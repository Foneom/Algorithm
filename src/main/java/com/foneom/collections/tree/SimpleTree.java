package com.foneom.collections.tree;

import java.security.spec.RSAOtherPrimeInfo;

/**
 * Класс представляющий все дерево
 */
public class SimpleTree {

    private Node root;

    public Node find(int key) {
        Node current = root; // начинаем с корня
        while (current.key != key ) {
            if (key < current.key) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert(int key, int data) {
        Node newNode = new Node();
        newNode.key = key;
        newNode.data = data;
        if (root == null) {
            root = newNode;
        } else {
            Node current = null;
            Node parent;
            while (true) {
                parent = current;
                if (key < current.key) {
                    current = current.leftChild;
                    if (current == null)  {
                        parent.leftChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void delete(int key) {

    }


}

/**
 * Класс узла дерева
 */
class Node {
    int key;
    int data;
    Node leftChild;
    Node rightChild;


}

