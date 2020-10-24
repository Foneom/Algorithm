package com.foneom.arrays;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class HighArrayTest {
    /**
     * л
     * Тест проверки метода линейного поиска в неотсортированном массиве
     */
    @Test
    public void isSearchedTrue() {
        HighArray arr = new HighArray(10);
        arr.insert(1);
        arr.insert(2);
        boolean expected = arr.lineSearch(2);
        assertThat(true, is(expected));
    }

    /**
     * Тест метода вставки нового элемента в массив
     */
    @Test
    public void isInsertedTrue() {
        HighArray arr = new HighArray(3);
        arr.insert(1);
        arr.insert(2);
        int[] actual = arr.getArr();
        int[] expected = new int[]{1, 2, 0};
        assertThat(actual, is(expected));
    }

    @Test
    public void removeElementIsTrue() {
        HighArray arr = new HighArray(4);
        arr.insert(2);
        arr.insert(1);
        arr.insert(3);
        arr.remove(1);
        int[] actual = arr.getArr();
        int[] expected = new int[]{2, 3, 0, 0};
        assertThat(expected, is(actual));
    }

    @Test
    public void deleteElementIsTrue() {
        HighArray arr = new HighArray(4);
        arr.insert(2);
        arr.insert(1);
        arr.insert(3);
        arr.deleteByKey(2);
        int[] actual = arr.getArr();
        int[] expected = new int[]{1, 3, 0, 0};
        assertThat(expected, is(actual));
    }

    /**
     * Тест сортировки пузырьком
     */
    @Test
    public void isBubbleSortTrue() {
        HighArray arr = new HighArray(3);
        arr.insert(2);
        arr.insert(1);
        arr.insert(3);
        arr.bubbleSort();
        int[] actual = arr.getArr();
        int[] expected = new int[]{1, 2, 3};
        assertThat(expected, is(actual));
    }
}