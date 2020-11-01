package com.foneom.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TrackerTest {

    /**
     * Тест метода добавления заявок
     */
    @Test
    public void whenAddTrue() {
        Tracker tracker = new Tracker();
        tracker.add(new Item());
        tracker.add(new Item());
        assertThat(2, is(tracker.getSize()));
    }

    @Test
    public void findByIdTrue(){
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        Item item2 = new Item();
        tracker.add(item1);
        tracker.add(item2);
        assertThat(item1, is(tracker.findById(item1.getId())));
        assertThat(item2, is(tracker.findById(item2.getId())));

    }

    @Test
    public void findByNameTrue() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("papa");
        Item item2 = new Item("mama");
        tracker.add(item1);
        tracker.add(item2);
        Item[] res1 = new Item[]{item1};
        assertThat(res1, is(tracker.findByName("mama")));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    /**
     * Метод удаления заявки
     */
    @Test
    public void whenDeleted(){
        Tracker tracker = new Tracker();
        Item papa = new Item();
        Item mama = new Item();
        tracker.add(papa);
        tracker.add(mama);
        tracker.delete(mama.getId());
        Item[] expected = new Item[]{papa};
        assertThat(tracker.findAll(), is(expected));

    }

}