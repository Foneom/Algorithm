package com.foneom.collections;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayListTest {

    @Test
    public void whenGetByIndex() {
        SimpleArrayList<Integer> list = new SimpleArrayList<Integer>(10);
        list.add(3);
        list.add(2);
        assertThat(2, is(list.get(1)));
    }
}