package com.foneom.collections.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class SimpleLinkedListTest {

    @Test
    public void whenAdd() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList();
        list.addFirst(3);
       // assertThat(3, is(list.print()));
    }
}