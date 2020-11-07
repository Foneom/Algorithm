package com.foneom.alphabet;

import java.util.*;

public class Alphabet implements Iterable{
   // private int[] arr = new int[] {0, 1, 2, 4, 5, 6, 7};
    private List<Integer> list;


    public Alphabet() {
        list = List.of(0, 1, 2, 4, 5, 6, 7);
    }
    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return list.get(index) < 6;
            }

            @Override
            public Object next() {
                return list.get(index++);
            }
        };
        }

    public static void main(String[] args) {
        Alphabet alphabet = new Alphabet();
        Iterator iterator = alphabet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
    }
    }

