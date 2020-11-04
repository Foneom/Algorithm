package com.foneom.collections.arraylist;

import com.foneom.collections.arraylist.SimpleArrayList;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.isA;
import static org.junit.Assert.*;

public class SimpleArrayListTest {

    @Test
    public void whenGetByIndex() {
        SimpleArrayList<Integer> list = new SimpleArrayList<Integer>(10);
        list.add(3);
        list.add(2);
        assertThat(2, is(list.get(1)));
    }

    @Test
    public void whenDelete() {
        SimpleArrayList<Integer> list = new SimpleArrayList<>(10);
        list.add(3);
        list.add(1);
        list.remove(0);
        assertThat(1,is(list.getSize()));
        assertThat(1, is(list.get(0)));
    }

    @Test
    public void whenSet() {
        SimpleArrayList<Integer> list = new SimpleArrayList<>(10);
        list.add(3);
        list.add(1);
        list.add(5);
        list.set(1, 7);
        assertThat(7, is(list.get(1)));
    }
    @Test
    public void whenIterator() {
        SimpleArrayList<Integer> list = new SimpleArrayList<>(10);
        list.add(3);
        list.add(1);
        list.add(5);
        Iterator<Integer> iter = list.iterator();
        assertThat(3, is(iter.next()));
        assertThat(1, is(iter.next()));
        assertThat(5, is(iter.next()));
    }
}