package com.foneom.collections.map.container;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class MapContainerTest {

    @Test
    public void whenInsertThenDelete() {
        MapContainer<String, String> store = new MapContainer<>();
        assertThat(store.put("Ivan", "Ivanych"), is(true));
        assertThat(store.get("Fedor"), is(nullValue()));
        assertThat(store.get("Ivan"), is("Ivanych"));
        assertThat(store.delete("Makar"), is(false));
        assertThat(store.delete("Ivan"), is(true));

    }

    @Test
    public void whenInsertUserObject() {
        MapContainer<String, Integer> store = new MapContainer<>();
        store.put("Papa", 67);
        assertThat(store.get("Papa"), is(67));
    }

    @Test
    public void whenInsertObjectWithSameHashCode() {
        MapContainer<String, String> store = new MapContainer<>();
        assertThat(store.put("Ivan", "Ivanych"), is(true));
        assertThat(store.put("Ivan", "Ivanov"), is(false));
    }

    @Test
    public void whenTryOperateWithEmptyStore() {
        MapContainer<String, String> store = new MapContainer<>();
        assertThat(store.get("Ivan"), is(nullValue()));
        assertThat(store.delete("Ivan"), is(false));
    }

    @Test
    public void whenInsertValueByKeyShouldGetByKeySameValue() {
        MapContainer<String, Integer> simpleMap = new MapContainer<>();
        simpleMap.put("ss", 5);
        assertThat(simpleMap.get("ss"), is(5));
    }


    @Test
    public void whenGetByKeyDoesNotExistShouldNull() {
        MapContainer<String, Integer> simpleMap = new MapContainer<>();
        assertNull(simpleMap.get("ss"));
    }

    @Test
    public void whenAddMoreThan16ValuesShouldIncreaseSize() {
        MapContainer<Integer, Integer> simpleMap = new MapContainer<>();
        for (int i = 0; i < 16; i++) {
            simpleMap.put(i, i);
        }
        assertTrue(simpleMap.put(25, 25));
        assertThat(simpleMap.get(25), is(25));
    }

    @Test
    public void whenDeleteValueShouldGetNullByKey() {
        MapContainer<String, Integer> simpleMap = new MapContainer<>();
        assertTrue(simpleMap.put("ss", 5));
        assertThat(simpleMap.get("ss"), is(5));
        assertTrue(simpleMap.delete("ss"));
        assertNull(simpleMap.get("ss"));
    }

    @Test
    public void whenDeleteValueNotPresentShouldFalse() {
        MapContainer<String, Integer> simpleMap = new MapContainer<>();
        assertFalse(simpleMap.delete("ss"));
    }

    @Test
    public void whenInsertKeyNullShouldGetValueByKey() {
        MapContainer<Integer, Integer> simpleMap = new MapContainer<>();
        assertTrue(simpleMap.put(5, 5));
        assertTrue(simpleMap.put(null, 7));
        assertTrue(simpleMap.put(15, 15));
        assertThat(simpleMap.get(null), is(7));
    }
    @Test
    public void whenIterateThanTrue() {
        MapContainer<Integer, String> simpleMap = new MapContainer<>();
        simpleMap.put(12, "first");
        simpleMap.put(16, "second");
        Iterator itr = simpleMap.iterator();
        assertThat(itr.hasNext(), is(true));
        System.out.println(itr.next());
        assertThat(itr.hasNext(), is(true));
        System.out.println(itr.next());
        assertThat(itr.hasNext(), is(false));
    }

}