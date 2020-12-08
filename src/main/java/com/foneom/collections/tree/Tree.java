package com.foneom.collections.tree;

import java.util.*;
import java.util.function.Predicate;

interface SimpleTr<E extends Comparable<E>> {
    /**
     * Добавление child в parent
     *
     * @param parent
     * @param child
     * @return
     */
    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);

    /**
     * Узле дерева
     *
     * @param <E>
     */
    class Node<E extends Comparable<E>> {
        private final E value;
        private final List<Node<E>> children = new ArrayList<>();

        public Node(E value) {
            this.value = value;
        }

        public void add(Node<E> child) {
            children.add(child);
        }

        public List<Node<E>> leaves() {
            return this.children;
        }

        public boolean eqValue(E that) {
            return value.compareTo(that) == 0;
        }
    }
}

/**
 * Эллеменарная структура дерева
 *
 * @param <E>
 */
public class Tree<E extends Comparable<E>> implements SimpleTr<E> {
    /**
     * Корень дерева
     */
    private final Node<E> root;

    /**
     * Конструктор дерева с указанным корнем
     *
     * @param root
     */
    public Tree(final E root) {
        this.root = new Node<E>(root);
    }

    /**
     * Метод добавления элемента child по ключу parent
     *
     * @param parent
     * @param child
     * @return
     */
    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        if (findBy(child).isEmpty()) {
            findBy(parent).ifPresent(node -> node.add(new Node<>(child)));
            rsl = true;
        }
        return rsl;
    }

    /**
     * Поиск узла по условию
     *
     * @param predicate
     * @return
     */
    private Optional<Node<E>> findNode(Predicate<Node<E>> predicate) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (predicate.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    /**
     * Метод проверки дерева на бинарность
     * @return
     */
    public boolean isBinary() {
        boolean rsl = true;
        if (findNode(node -> node.leaves().size() > 2).isPresent()) {
            rsl = false;
        }
        return rsl;
    }


    /**
     * Метод поиска по ключу
     * @param value
     * @return
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        return findNode(node -> node.eqValue(value));
    }

}

