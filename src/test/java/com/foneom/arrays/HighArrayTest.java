package com.foneom.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class HighArrayTest {

    @Test
    public void isSearchedTrue() {
        HighArray arr = new HighArray(10);
        arr.insert(1);
        arr.insert(2);
        boolean actual = arr.search(2);
        assertTrue(actual);
    }

    @Test
    public void isInsertedTrue() {
        HighArray arr = new HighArray(10);
        arr.insert(1);
        arr.insert(2);
        assertEquals(2, arr.getNElem());
    }
}